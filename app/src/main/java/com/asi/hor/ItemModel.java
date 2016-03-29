package com.asi.hor;


 public class ItemModel {

     // Getter and Setter model for recycler view items
     private String title;
     private int image;

     public ItemModel(String title, int image) {

         this.title = title;

         this.image = image;
     }

     public String getTitle() {
         return title;
     }


     public int getImage() {
         return image;
     }
 }
