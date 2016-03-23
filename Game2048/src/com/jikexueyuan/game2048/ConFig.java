package com.jikexueyuan.game2048;

import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

public class ConFig {
	public static BluetoothServerSocket mserverSocket = null;
	public static BluetoothSocket socket = null;
	public static int MODE_SELECT = 0;
	public static MainBase mb;
	public static boolean isMaster = false;
}
