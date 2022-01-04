/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lenovo
 */
@Controller
public class ProjekcController {
    @RequestMapping ("/AZIZ")
    public String prosesInputan (HttpServletRequest data, Model get)
    {
        String inputBuah = data.getParameter("namabuah");
        String inputHarga = data.getParameter("hargaperkilo");
        Integer hargaBuah = Integer.valueOf(inputHarga);
        String inputJumlahBeli = data.getParameter("jumlahbeli");
        Double jumlahBeli = Double.valueOf(inputJumlahBeli);
        Double jumlahBayar = hargaBuah * jumlahBeli;
        Double totalBayar = null;
        Integer diskon = 15;
        Double hargadiskon = 0.0;
        if (jumlahBayar < 16000)
        {
            totalBayar = jumlahBayar - (jumlahBayar * 0/100);
            
        }
        else if (jumlahBayar > 16000 || jumlahBayar < 25000)
        {
            totalBayar = jumlahBayar - (jumlahBayar * 10/100);
            
        }
        else if (jumlahBayar > 25000)
        {
            totalBayar = jumlahBayar - (jumlahBayar * 15/100);
            
        }
       
        get.addAttribute("varbuah", inputBuah);
        get.addAttribute("varharga", inputHarga);
        get.addAttribute("varjumlah", inputJumlahBeli);
        get.addAttribute("vartotal", totalBayar);
        get.addAttribute("discountrp", hargadiskon);
        get.addAttribute("disc", diskon);
        return "Azizfathoni";
    }
}

