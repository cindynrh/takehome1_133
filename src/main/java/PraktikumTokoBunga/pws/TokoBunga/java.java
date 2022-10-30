/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PraktikumTokoBunga.pws.TokoBunga;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
public class java {
    @RequestMapping("/input")
    public String getData(HttpServletRequest data, Model discountprocess){
        
        String inputname = data.getParameter("var_name");
        
        String inputprice = data.getParameter("var_price");
        
        String inputquantity = data.getParameter("var_quantity");
        
//        String inputBuy = data.getParameter("var_Buy");
        
        String diskon = "";

        Double iPrice = Double.valueOf(inputprice);
        Double iTotal = Double.valueOf(inputquantity);
//        Double iBuy = Double.valueOf(inputBuy);
        Double PriceTotal = iPrice * iTotal;
        Double getTotal = null;
        
        if (PriceTotal < 20000)
        {
            getTotal = PriceTotal - (0 * PriceTotal/100);
            diskon = "0%";
        }
        else if (PriceTotal >= 20000 && PriceTotal < 30000)
        {
            getTotal = PriceTotal - (10 * PriceTotal/100);
            diskon = "10%";
        }
        else if (PriceTotal >= 30000)
        {
            getTotal =PriceTotal - (15 * PriceTotal/100);
            diskon ="15%";
        }
        
        discountprocess.addAttribute("Name", inputname);
        discountprocess.addAttribute("Price", inputprice);
        discountprocess.addAttribute("Quantity", inputquantity);
        discountprocess.addAttribute("Total", getTotal);
        discountprocess.addAttribute("Diskon", diskon);
//        discountprocess.addAttribute("Buy", inputBuy);
 
        return "hasil";
    }
}
