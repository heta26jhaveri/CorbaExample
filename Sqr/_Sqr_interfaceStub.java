package Sqr;

/**
 * Sqr/_Sqr_interfaceStub.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.2" from Sqr.idl Thursday, March 17, 2016 9:58:48 AM
 * IST
 */
public class _Sqr_interfaceStub extends org.omg.CORBA.portable.ObjectImpl implements Sqr.Sqr_interface {

    public int findSqr(int n) {
        org.omg.CORBA.portable.InputStream $in = null;
        try {
            org.omg.CORBA.portable.OutputStream $out = _request("findSqr", true);
            $out.write_long(n);
            $in = _invoke($out);
            int $result = $in.read_long();
            return $result;
        } catch (org.omg.CORBA.portable.ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (org.omg.CORBA.portable.RemarshalException $rm) {
            return findSqr(n);
        } finally {
            _releaseReply($in);
        }
    } // findSqr

    // Type-specific CORBA::Object operations
    private static String[] __ids = {
        "IDL:Sqr/Sqr_interface:1.0"};

    public String[] _ids() {
        return (String[]) __ids.clone();
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException {
        String str = s.readUTF();
        String[] args = null;
        java.util.Properties props = null;
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
        try {
            org.omg.CORBA.Object obj = orb.string_to_object(str);
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            _set_delegate(delegate);
        } finally {
            orb.destroy();
        }
    }

    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        String[] args = null;
        java.util.Properties props = null;
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
        try {
            String str = orb.object_to_string(this);
            s.writeUTF(str);
        } finally {
            orb.destroy();
        }
    }
} // class _Sqr_interfaceStub