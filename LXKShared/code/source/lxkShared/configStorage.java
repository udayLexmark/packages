package lxkShared;

import java.util.Hashtable;

public final class configStorage
{

	private static Hashtable configStorage = new Hashtable();

	public static Hashtable getConfigStorage()
	{
		return configStorage;
	}

	public static void setConfigStorage(Hashtable newHash)
	{
		configStorage = newHash;
	}
}
