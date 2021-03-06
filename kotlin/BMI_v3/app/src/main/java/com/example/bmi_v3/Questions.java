package com.example.bmi_v3;

public class Questions {
    public String mQuestions[] = {
            "What is the name of the disease caused by SARS-Cov-2 virus?",
            "There is a rumor that SARS-Cov-2 virus spread because some animal was eaten. What was" +
                    " that animal?",
            "How many people died in pandemia called Spanish Flu?",
            "What is the name of the region in Italy with most of the infected persons?",
            "CoronaVirus comes from: ",
            "Spanish flu took place during some war. What is the name of this conflict?",
            "What is the most important product during quarantine/isolation?",
            "What is the name of the virus which spread all over the world in 2019/2020?",
            "What main sport event was postponed due to CoronaVirus?",
            "How long should you wash your hands to clean them up?",
            "What beer name reminds you of current Pandemia?",
            "What is the name of the hashtag which calls you to stay at home?",
            "What products are forbidden to sell in allegro due to pandemia?"
    };
    private String mChoices[][] = {
            {"COVID-17", "COVID-18", "COVID-19", "COVID-20"},
            {"Bat", "Spider", "Snake", "Rhino"},
            {"1 - 10 millions", "11 - 20 millions", "21 - 100 millions", "101 - 200 millions"},
            {"Mediolan", "Bonasera", "Lombardia", "Sicilia"},
            {"China", "Poland", "Italy", "Spain"},
            {"WWI", "Warsaw uprising", "WWII", "13 years war"},
            {"Bread", "Meat", "Toilet Paper", "Money"},
            {"SARS-Cov-2 virus", "Ebola", "Sars", "Mad Cow disease"},
            {"Russia World Cup 2018", "2020 Tokyo Olympics", "Euro 2012", "2016 London Olympics"},
            {"15 seconds", "30 seconds", "45 seconds", "60 seconds"},
            {"Dzik", "Tyskie", "Corona", "Guinness"},
            {"#siedzNaDupie", "#zostanWdomu", "#dzban", "#wirusSwirus"},
            {"Toilet Paper", "Protective Masks", "Alcohol", "Drugs"}
    };

    private String mCorrectAnswears[] = {
            "COVID-19", "Bat", "21 - 100 millions", "Lombardia", "China", "WWI", "Toilet Paper",
            "SARS-Cov-2 virus", "2020 Tokyo Olympics", "30 seconds", "Corona", "#zostanWdomu",
            "Protective Masks"
    };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswear(int a){
        String answear = mCorrectAnswears[a];
        return answear;
    }
}
