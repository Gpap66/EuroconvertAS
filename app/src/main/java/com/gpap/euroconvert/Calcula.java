package com.gpap.euroconvert;

public class Calcula {
    double apot = 0;

    public Double toEuroKg(double dol, double pd) {

        double seKg = 0.453 * pd;
        double seEr = 0.76 * dol;

        apot = seEr / seKg;
        apot = Math.round(apot * 100);
        apot = apot / 100;
        return apot;

    }

}
