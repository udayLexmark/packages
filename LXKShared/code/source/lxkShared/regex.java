package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-03-10 16:01:00 EST
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.regex.*;
// --- <<IS-END-IMPORTS>> ---

public final class regex

{
	// ---( internal utility methods )---

	final static regex _instance = new regex();

	static regex _newInstance() { return new regex(); }

	static regex _cast(Object o) { return (regex)o; }

	// ---( server methods )---




	public static final void find (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(find)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required regex
		// [i] field:0:required input
		// [o] recref:0:required resultSet PSUtilities.regex:resultSet
		// Toni Immordino
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String regex = IDataUtil.getString( pipelineCursor, "regex" );
		String input = IDataUtil.getString( pipelineCursor, "input" );
		pipelineCursor.destroy();
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(input);
		
		int sets = 0;
		
		while (matcher.find())
		{
			sets++;
		}
		
		matcher.reset();
		
		int i = 0;
		
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		
		// resultSet
		IData	resultSet = IDataFactory.create();
		IDataCursor resultSetCursor = resultSet.getCursor();
		
		
		// resultSet.result
		IData[]	result = new IData[sets];
		
		while (matcher.find())
		{
			result[i] = IDataFactory.create();
			IDataCursor resultCursor = result[i].getCursor();
			IDataUtil.put( resultCursor, "text", matcher.group() );
			IDataUtil.put( resultCursor, "start", Integer.toString(matcher.start()));
			IDataUtil.put( resultCursor, "end", Integer.toString(matcher.end()));
			resultCursor.destroy();
			IDataUtil.put( resultSetCursor, "result", result );
			resultSetCursor.destroy();
		
			i++;
		}
		
		IDataUtil.put( pipelineCursor_1, "resultSet", resultSet );
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}
}

