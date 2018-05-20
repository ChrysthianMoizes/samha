package cgt;

public abstract class Horarios {
    
    public static final String MATUTINO_1 = "07:00 - 07:50";
    public static final String MATUTINO_2 = "07:55 - 08:45";
    public static final String MATUTINO_3 = "08:50 - 09:40";
    public static final String MATUTINO_4 = "10:00 - 10:50";
    public static final String MATUTINO_5 = "10:55 - 11:45";
    public static final String MATUTINO_6 = "11:50 - 12:40";
    
    public static final String VESPERTINO_1 = "12:50 - 13:40";
    public static final String VESPERTINO_2 = "13:45 - 14:35";
    public static final String VESPERTINO_3 = "14:40 - 15:30";
    public static final String VESPERTINO_4 = "15:50 - 16:40";
    public static final String VESPERTINO_5 = "16:45 - 17:35";
    public static final String VESPERTINO_6 = "17:40 - 18:30";
    
    public static final String NOTURNO_1 = "18:50 - 19:35";
    public static final String NOTURNO_2 = "19:35 - 20:20";
    public static final String NOTURNO_3 = "20:30 - 21:15";
    public static final String NOTURNO_4 = "21:15 - 22:00";
    public static final String NOTURNO_5 = "--";
    public static final String NOTURNO_6 = "--";
    
    public static final double INICIAL_0 = 7;
    public static final double INICIAL_1 = 8;
    public static final double INICIAL_2 = 9;
    public static final double INICIAL_3 = 10;
    public static final double INICIAL_4 = 11;
    public static final double INICIAL_5 = 12;
    public static final double INICIAL_6 = 13;
    public static final double INICIAL_7 = 14;
    public static final double INICIAL_8 = 15;
    public static final double INICIAL_9 = 16;
    public static final double INICIAL_10 = 17;
    public static final double INICIAL_11 = 18;
    public static final double INICIAL_12 = 19;
    public static final double INICIAL_13 = 20;
    public static final double INICIAL_14 = 21;
    public static final double INICIAL_15 = 22;
    public static final double INICIAL_16 = 0;
    public static final double INICIAL_17 = 0;
    public static final double INICIAL_18 = 0;
    
    public static final double FINAL_0 = 7;
    public static final double FINAL_1 = 7;
    public static final double FINAL_2 = 7;
    public static final double FINAL_3 = 7;
    public static final double FINAL_4 = 7;
    public static final double FINAL_5 = 7;
    public static final double FINAL_6 = 7;
    public static final double FINAL_7 = 7;
    public static final double FINAL_8 = 7;
    public static final double FINAL_9 = 7;
    public static final double FINAL_10 = 7;
    public static final double FINAL_11 = 7;
    public static final double FINAL_12 = 7;
    public static final double FINAL_13 = 7;
    public static final double FINAL_14 = 7;
    public static final double FINAL_15 = 7;
    public static final double FINAL_16 = 7;
    public static final double FINAL_17 = 7;
    public static final double FINAL_18 = 7;
    
    public static double horarioInicial(int numero){
        
        switch(numero){
            
            case 0: return INICIAL_0;
            case 1: return INICIAL_1;
            case 2: return INICIAL_2;
            case 3: return INICIAL_3;
            case 4: return INICIAL_4;
            case 5: return INICIAL_5;
            case 6: return INICIAL_6;
            case 7: return INICIAL_7;
            case 8: return INICIAL_8;
            case 9: return INICIAL_9;
            case 10: return INICIAL_10;
            case 11: return INICIAL_11;
            case 12: return INICIAL_12;
            case 13: return INICIAL_13;
            case 14: return INICIAL_14;
            case 15: return INICIAL_15;
            case 16: return INICIAL_16;
            case 17: return INICIAL_17;
            default: return INICIAL_18;
            
        }
    }
    
    public static double horarioFinal(int numero){
        
        switch(numero){
            
            case 0: return FINAL_0;
            case 1: return FINAL_1;
            case 2: return FINAL_2;
            case 3: return FINAL_3;
            case 4: return FINAL_4;
            case 5: return FINAL_5;
            case 6: return FINAL_6;
            case 7: return FINAL_7;
            case 8: return FINAL_8;
            case 9: return FINAL_9;
            case 10: return FINAL_10;
            case 11: return FINAL_11;
            case 12: return FINAL_12;
            case 13: return FINAL_13;
            case 14: return FINAL_14;
            case 15: return FINAL_15;
            case 16: return FINAL_16;
            case 17: return FINAL_17;
            default: return FINAL_18;
            
        }
    }
}
