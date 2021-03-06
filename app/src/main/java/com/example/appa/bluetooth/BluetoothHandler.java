package com.example.appa.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;


import com.example.appa.R;
import com.example.appa.bluetooth.message.MessageHandler;
import com.example.appa.bluetooth.threads.AttemptConnectionThread;
import com.example.appa.bluetooth.threads.ConnectedDeviceThread;

import java.util.Set;


public class BluetoothHandler extends Activity {
    private int status = 0; // 0 = no actions / 2 = connecting / 3 = connected
    //this is the bluetooth adapter
    private BluetoothAdapter btAdapter;
    //this handles messages
    private MessageHandler messageHandler;
    //this is the address to my house
    private String address;

    //this contains the thread to the connected device
    ConnectedDeviceThread connectedDeviceThread;
    //this attempts connection to a device in a thread
    AttemptConnectionThread attemptConnectionThread;


    // Instantiated with a messagehandler
    public BluetoothHandler(MessageHandler messageHandler) {
        // Get bluetoothadapter.
        // Null means bluetooth is not supported.
        btAdapter = BluetoothAdapter.getDefaultAdapter();

        // Enabled bluetooth if not enabled.
        if(!btAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            // TODO:
            // Implement bluetooth dialog when bluetooth is not enabled.
        }

        this.messageHandler = messageHandler;
    }

    //this is a method
    public synchronized  void connect() {
        //these are a bunch of letters
        BluetoothDevice device = getBtAdapter().getRemoteDevice(address);
        connect(device);
    }

    public synchronized void connect(BluetoothDevice btDevice)
    {
        if(status == 2 && attemptConnectionThread != null)
        {
            attemptConnectionThread.cancel();
            attemptConnectionThread = null;
        }

        if(connectedDeviceThread != null) {
            connectedDeviceThread.cancel();
            connectedDeviceThread = null;
        }

        attemptConnectionThread = new AttemptConnectionThread(this, messageHandler, btDevice);
        attemptConnectionThread.start();
        setStatus(2);
        messageHandler.sendConnectingTo(btDevice.getName());
    }

    public synchronized void connected(BluetoothDevice btDevice, BluetoothSocket btSocket)
    {

        if(attemptConnectionThread != null)
        {
            attemptConnectionThread.cancel();
            attemptConnectionThread = null;
        }

        if(connectedDeviceThread != null)
        {
            connectedDeviceThread.cancel();
            connectedDeviceThread = null;
        }

        connectedDeviceThread = new ConnectedDeviceThread(this, messageHandler, btSocket);
        connectedDeviceThread.start();

        setStatus(3);
        messageHandler.sendConnectedTo(btDevice.getName());
    }

    public synchronized void disconnect() {
        if(attemptConnectionThread != null)
        {
            attemptConnectionThread.cancel();
            attemptConnectionThread = null;
        }

        if(attemptConnectionThread != null)
        {
            connectedDeviceThread.shutdown();
            connectedDeviceThread.cancel();
            connectedDeviceThread = null;
        }

        messageHandler.sendNotConnected();
        setStatus(0);
    }

    public boolean btAdapterAvailable()
    {
        return btAdapter != null;
    }

    public boolean btAdapterEnabled()
    {
        if(btAdapterAvailable()){
            return btAdapter.isEnabled();
        }
        return false;

    }

    public Set<BluetoothDevice> getDevices()
    {
        return btAdapter.getBondedDevices();
    }

    public void startDiscover()
    {
        btAdapter.startDiscovery();
    }

    public void stopDiscover()
    {
        btAdapter.cancelDiscovery();
    }

    public boolean isDiscovering()
    {
        return btAdapter.isDiscovering();
    }

    public BluetoothAdapter getBtAdapter() {
        return btAdapter;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public ConnectedDeviceThread getConnectedDeviceThread() {
        return connectedDeviceThread;
    }

    public void setConnectedDeviceThread(ConnectedDeviceThread connectedDeviceThread) {
        this.connectedDeviceThread = connectedDeviceThread;
    }

    public AttemptConnectionThread getAttemptConnectionThread() {
        return attemptConnectionThread;
    }

    public void setAttemptConnectionThread(AttemptConnectionThread attemptConnectionThread) {
        this.attemptConnectionThread = attemptConnectionThread;
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
