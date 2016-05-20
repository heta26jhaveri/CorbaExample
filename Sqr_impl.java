
import Sqr.Sqr_interfacePOA;
import org.omg.CORBA.ORB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apple
 */
public class Sqr_impl extends Sqr_interfacePOA{

    ORB orb;

    public Sqr_impl(ORB orb) {
        this.orb = orb;
    }
    
    
    @Override
    public int findSqr(int n) {
        return n*n;
    }
    
}
