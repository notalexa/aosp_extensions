/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package android.os;
/**
 * @hide
 */
public interface IIdmap2 extends android.os.IInterface
{
  /** Default implementation for IIdmap2. */
  public static class Default implements android.os.IIdmap2
  {
    @Override public java.lang.String getIdmapPath(java.lang.String overlayApkPath, int userId) throws android.os.RemoteException
    {
      return null;
    }
    @Override public boolean removeIdmap(java.lang.String overlayApkPath, int userId) throws android.os.RemoteException
    {
      return false;
    }
    @Override public boolean verifyIdmap(java.lang.String overlayApkPath, int fulfilledPolicies, boolean enforceOverlayable, int userId) throws android.os.RemoteException
    {
      return false;
    }
    @Override public java.lang.String createIdmap(java.lang.String targetApkPath, java.lang.String overlayApkPath, int fulfilledPolicies, boolean enforceOverlayable, int userId) throws android.os.RemoteException
    {
      return null;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements android.os.IIdmap2
  {
    private static final java.lang.String DESCRIPTOR = "android.os.IIdmap2";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an android.os.IIdmap2 interface,
     * generating a proxy if needed.
     */
    public static android.os.IIdmap2 asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof android.os.IIdmap2))) {
        return ((android.os.IIdmap2)iin);
      }
      return new android.os.IIdmap2.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_getIdmapPath:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          int _arg1;
          _arg1 = data.readInt();
          java.lang.String _result = this.getIdmapPath(_arg0, _arg1);
          reply.writeNoException();
          reply.writeString(_result);
          return true;
        }
        case TRANSACTION_removeIdmap:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          int _arg1;
          _arg1 = data.readInt();
          boolean _result = this.removeIdmap(_arg0, _arg1);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          return true;
        }
        case TRANSACTION_verifyIdmap:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          int _arg1;
          _arg1 = data.readInt();
          boolean _arg2;
          _arg2 = (0!=data.readInt());
          int _arg3;
          _arg3 = data.readInt();
          boolean _result = this.verifyIdmap(_arg0, _arg1, _arg2, _arg3);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          return true;
        }
        case TRANSACTION_createIdmap:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          java.lang.String _arg1;
          _arg1 = data.readString();
          int _arg2;
          _arg2 = data.readInt();
          boolean _arg3;
          _arg3 = (0!=data.readInt());
          int _arg4;
          _arg4 = data.readInt();
          java.lang.String _result = this.createIdmap(_arg0, _arg1, _arg2, _arg3, _arg4);
          reply.writeNoException();
          reply.writeString(_result);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements android.os.IIdmap2
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      @Override public java.lang.String getIdmapPath(java.lang.String overlayApkPath, int userId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(overlayApkPath);
          _data.writeInt(userId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getIdmapPath, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getIdmapPath(overlayApkPath, userId);
          }
          _reply.readException();
          _result = _reply.readString();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public boolean removeIdmap(java.lang.String overlayApkPath, int userId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(overlayApkPath);
          _data.writeInt(userId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_removeIdmap, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().removeIdmap(overlayApkPath, userId);
          }
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public boolean verifyIdmap(java.lang.String overlayApkPath, int fulfilledPolicies, boolean enforceOverlayable, int userId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(overlayApkPath);
          _data.writeInt(fulfilledPolicies);
          _data.writeInt(((enforceOverlayable)?(1):(0)));
          _data.writeInt(userId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_verifyIdmap, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().verifyIdmap(overlayApkPath, fulfilledPolicies, enforceOverlayable, userId);
          }
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public java.lang.String createIdmap(java.lang.String targetApkPath, java.lang.String overlayApkPath, int fulfilledPolicies, boolean enforceOverlayable, int userId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(targetApkPath);
          _data.writeString(overlayApkPath);
          _data.writeInt(fulfilledPolicies);
          _data.writeInt(((enforceOverlayable)?(1):(0)));
          _data.writeInt(userId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_createIdmap, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().createIdmap(targetApkPath, overlayApkPath, fulfilledPolicies, enforceOverlayable, userId);
          }
          _reply.readException();
          _result = _reply.readString();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static android.os.IIdmap2 sDefaultImpl;
    }
    static final int TRANSACTION_getIdmapPath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_removeIdmap = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_verifyIdmap = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_createIdmap = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    public static boolean setDefaultImpl(android.os.IIdmap2 impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static android.os.IIdmap2 getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public static final int POLICY_PUBLIC = 1;
  public static final int POLICY_SYSTEM_PARTITION = 2;
  public static final int POLICY_VENDOR_PARTITION = 4;
  public static final int POLICY_PRODUCT_PARTITION = 8;
  public static final int POLICY_SIGNATURE = 16;
  public static final int POLICY_ODM_PARTITION = 32;
  public static final int POLICY_OEM_PARTITION = 64;
  public java.lang.String getIdmapPath(java.lang.String overlayApkPath, int userId) throws android.os.RemoteException;
  public boolean removeIdmap(java.lang.String overlayApkPath, int userId) throws android.os.RemoteException;
  public boolean verifyIdmap(java.lang.String overlayApkPath, int fulfilledPolicies, boolean enforceOverlayable, int userId) throws android.os.RemoteException;
  public java.lang.String createIdmap(java.lang.String targetApkPath, java.lang.String overlayApkPath, int fulfilledPolicies, boolean enforceOverlayable, int userId) throws android.os.RemoteException;
}
