package com.example.ajayrwarrier.quizmaster;

/**
 * Created by Ajay R Warrier on 23-10-2016.
 */
public class Questions {
    private int Qno;
    private String Question;
    private String OP_A;
    private String OP_B;
    private String OP_C;
    private String ANS;
    private String ANS2;
    private String ANS3;
    private int ANScount;

    public Questions() {
        Qno = 0;
        Question = "";
        OP_A = "";
        OP_B = "";
        OP_C = "";
        ANS = "";
    }

    public Questions(int Quesno, String Questn, String A, String B, String C, String Ans) {
        Qno = Quesno;
        Question = Questn;
        OP_A = A;
        OP_B = B;
        OP_C = C;
        ANS = Ans;
        ANScount = 1;

    }

    public Questions(int Quesno, String Questn, String A, String B, String C, String Ans1, String Ans2) {
        Qno = Quesno;
        Question = Questn;
        OP_A = A;
        OP_B = B;
        OP_C = C;
        ANS = Ans1;
        ANS2 = Ans2;

        ANScount = 3;

    }

    public Questions(int Quesno, String Questn, String A, String B, String C, String Ans1, String Ans2, String Ans3) {
        Qno = Quesno;
        Question = Questn;
        OP_A = A;
        OP_B = B;
        OP_C = C;
        ANS = Ans1;
        ANS2 = Ans2;
        ANS3 = Ans3;
        ANScount = 6;

    }

    public int getQno() {
        return Qno;
    }

    public String getQuestion() {
        return Question;
    }

    public String getOP_A() {
        return OP_A;
    }

    public String getOP_B() {
        return OP_B;
    }

    public String getOP_C() {
        return OP_C;
    }

    public String getANS() {
        return ANS;
    }

    public String getANS2() {
        return ANS2;
    }

    public String getANS3() {
        return ANS3;
    }

    public int getANScount() {
        return ANScount;
    }
}

