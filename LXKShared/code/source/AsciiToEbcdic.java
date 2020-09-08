

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 02:12:30 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.lang.*;
import java.util.*;
import java.text.*;
// --- <<IS-END-IMPORTS>> ---

public final class AsciiToEbcdic

{
	// ---( internal utility methods )---

	final static AsciiToEbcdic _instance = new AsciiToEbcdic();

	static AsciiToEbcdic _newInstance() { return new AsciiToEbcdic(); }

	static AsciiToEbcdic _cast(Object o) { return (AsciiToEbcdic)o; }

	// ---( server methods )---




	public static final void EBCDICToAscii (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(EBCDICToAscii)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [i] field:0:required trim {&quot;true&quot;,&quot;false&quot;}
		// [o] field:0:required outString
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	inString = IDataUtil.getString( pipelineCursor, "inString" );
			String	trim = IDataUtil.getString( pipelineCursor, "trim" );
		
		String outString = "";
		int j = 0;
		
		while (j < inString.length())
		{
			outString = outString + translateString(inString.substring(j,j+2));
			j = j+2;
		}
		
		if ((trim!= null) && (trim.equals("true")))
			outString = outString.trim();
		
		IDataUtil.put( pipelineCursor, "outString", outString);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void toBigDecimal (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(toBigDecimal)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required start
		// [i] field:0:required length
		// [i] field:0:required scale
		// [i] field:0:required value
		// [o] field:0:required output
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			int start = Integer.parseInt(IDataUtil.getString( pipelineCursor, "start" ));
			int length = Integer.parseInt(IDataUtil.getString( pipelineCursor, "length" ));
			int	scale = Integer.parseInt(IDataUtil.getString( pipelineCursor, "scale" ));
			byte[] value = (IDataUtil.getString( pipelineCursor, "valueS" )).getBytes();
		pipelineCursor.destroy();
		
			// Allocate the result buffer
			StringBuffer result = new StringBuffer(2 * length);
		
			// Process each byte of the packed decimal number
			for (int n = 0; n < length; n++)
			{
				// Get the two digits from the byte
				final int b = unsignedValue(value[start + n]);
				final int digit1 = (b >> 4) & 0x0F;
				final int digit2 = b & 0x0F;
		
				// Validate the first digit
				if (digit1 > 9)
					throw new NumberFormatException("Invalid packed decimal data");
		
				// Build up the result buffer
				result.append((char) (digit1 + '0'));
		
				// If this is the last byte, the second digit has the sign
				if (n == (length - 1))
				{
					// Get the sign
					switch (digit2)
					{
						// Invlaid sign
						default :
							throw new NumberFormatException("Invalid packed decimal data");
		
							// Positive sign
						case 0x0A :
						case 0x0C :
						case 0x0E :
						case 0x0F :
							break;
		
							// Negative sign
						case 0x0B :
						case 0x0D :
							result.insert(0, '-');
							break;
					}
				}
				else
				{
					// Not the last byte of the packed number. Validate the 2nd digit of the byte.
					if (digit2 > 9)
						throw new NumberFormatException("Invalid packed decimal data");
		
					// Build up the result buffer
					result.append((char) (digit2 + '0'));
				}
			}
		
			// Convert the result to a big decimal and adjust the implied decimal point.
			//return new BigDecimal(result.toString()).movePointLeft(scale);
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "output", result.toString() );
		pipelineCursor_1.destroy();
		
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static final int SIZE = 92;
	private static final String ASCII[] = {
	" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
	"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e",
	"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
	"v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "{",
	"|", "}", "~", ":", ";", "<", "=", ">", "?", "@", "#", "$", "%", "&", "'", "(",
	")", "*", "+", ",", "-", ".", "[", "]", "_", "`","^","/"
	};      
	
	private static final String EBCDIC[] = {
	"40","C1","C2","C3","C4","C5","C6","C7","C8","C9","D1","D2","D3","D4","D5","D6",
	"D7","D8","D9","E2","E3","E4","E5","E6","E7","E8","E9","81","82","83","84","85",
	"86","87","88","89","91","92","93","94","95","96","97","98","99","A2","A3","A4",
	"A5","A6","A7","A8","A9","F0","F1","F2","F3","F4","F5","F6","F7","F8","F9","C0",
	"6A","D0","A1","7A","5E","4C","7E","6E","6F","7C","7B","5B","6C","50","7D","4D",
	"5D","5C","4E","6B","60","4B","4F","5F","6E","79","6D","2F"
	};      
	
	public final static String translateString(String x) 
	{
		for (int j = 0; j<SIZE; j++) 
		{
	    	if (x.equals(EBCDIC[j])) 
	        	return ASCII[j];
		}        
	    return x;
	}
	
	/**
	 * Convert the value of an integer in the range (0..255) to a signed byte (-128..127).
	 *
	 * @return byte
	 * @param n int
	 */
	public static byte signedValue(int n)
	{
		return (byte) (n > 127 ? n - 256 : n);
	}
	
	/**
	 * Return the value of a byte treated as an unsigned number (0..255).
	 *
	 * @return int
	 * @param b byte
	 */
	public static int unsignedValue(byte b)
	{
		return b < 0 ? b + 256 : b;
	}
	// --- <<IS-END-SHARED>> ---
}

