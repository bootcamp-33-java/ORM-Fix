/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm;

import daos.CountryDAO;
import idaos.ICountryDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Country;
import models.Region;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Tutus
 */
public class manualTestCountry {

    /**
     * @param args the command line arguments
     */
    
//    public void getAll(){
//        Country country = CountryDAO.getAll();
//        AssertionError.assertNotNull(country);
//    }
      
    public static void main(String[] args) {
        // TODO code application logic here
        SessionFactory factory = HibernateUtil.getSessionFactory();
     
        
        
        //--------- GET ALL ---------------//
//        CountryDAO cdao = new CountryDAO(factory);
//        List<Country> countrys = cdao.getAll();
//        for (Country country : countrys) {
//            System.out.println(country.getCountryId());
//            System.out.println(country.getCountryName());
//            System.out.println(country.getRegionId());
//        }
//        //------------- INSERT ------------//
        CountryDAO cdao = new CountryDAO(factory);
//        List<Country> countrys = cdao.insert("se","semarang",);
//        for (Country country : countrys) {
//            System.out.println(country.getCountryId());
//            System.out.println(country.getCountryName());
//            System.out.println(country.getRegionId());
//        }
//          ------------- GET BY ID -----------//
//               Country country = cdao.getById("ZM");
//               System.out.println(country.getCountryId()+" = "+country.getCountryName());

            
//          ------------ DELETE ------------//
//           System.out.println(cdao.delete("ZW"));

//          ------------ SEARCH ------------//
            for (Country country : cdao.search("a")) {
                System.out.println(country.getCountryId());
                System.out.println(country.getCountryName());
                System.out.println(country.getRegionId().getRegionId());
        }

//            ICountryDAO icdao = new CountryDAO(factory);
//            System.out.println(icdao.save("SM","SEMARANG",1));

    }
    
}
