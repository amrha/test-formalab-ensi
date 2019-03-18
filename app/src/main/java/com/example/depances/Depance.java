package com.example.depances;
public class Depance {
        private String jour;
        private String mois;
        private String année;
        private String montant;
        private String achat;
        public Depance() { }
        public Depance(String jour, String mois,String année ,String montant,String achat) {
            this.jour = jour;
            this.mois = mois;
            this.année=année;
            this.montant=montant;
            this.achat=achat;}
    public String getJour() {
        return jour; }
    public void setJour(String jour) {
        this.jour = jour; }
    public String getMois() {
        return mois; }
    public void setMois(String mois) {
        this.mois = mois; }
    public String getAnnée() {
        return année; }
    public void setAnnée(String année) {
        this.année = année; }
    public String getMontant() {
        return montant; }
    public void setMontant(String montant) {
        this.montant = montant; }
    public String getAchat() {
        return achat; }
    public void setAchat(String achat) {
        this.achat = achat; }}
