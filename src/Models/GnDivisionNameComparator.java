/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Comparator;

/**
 *
 * @author NCCS
 */
public class GnDivisionNameComparator implements Comparator<GnDivision>{

    @Override
    public int compare(GnDivision o1, GnDivision o2) {
        return o1.getEnglish().compareTo(o2.getEnglish());
    }
    
}
