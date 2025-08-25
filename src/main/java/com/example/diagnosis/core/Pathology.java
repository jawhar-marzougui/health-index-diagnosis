package com.example.diagnosis.core;


public enum Pathology {
CARDIOLOGIE("Cardiologie"),
TRAUMATOLOGIE("Traumatologie");


private final String label;


Pathology(String label) {
this.label = label;
}


public String label() {
return label;
}
}