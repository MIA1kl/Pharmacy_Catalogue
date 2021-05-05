# Pharmacy_Catalogue


<img src="https://upload.wikimedia.org/wikipedia/en/0/07/Ala-Too_International_University_Seal.png" width="20%" />

## Author: Natalia Klimareva and Fatima Bekmamatova COM19-A

Pharmacy catalogs are used so that the customer can find out the availability of the desired product and its price without leaving the house.

This is the .gif of the website, but also you can visit the site by yourself: [Click here](https://ph-catalogue-cs204.herokuapp.com) to see the project on Heroku

![Alt Text](https://github.com/Fattijenishbek/extra_files/blob/master/ezgif.com-gif-maker%20(1).gif)

This is the how we implemented the search code:

![Screenshot from 2021-05-06 02-37-44](https://user-images.githubusercontent.com/57977808/117206056-31062f80-ae14-11eb-9df3-49dc04dc1922.png)

If you try to access not existing address, following "Not Found" page appears

<img src="https://github.com/MIA1kl/Pharmacy_Catalogue/blob/master/images/2021-03-19_01-45-02.png" /> 

## API Description:

* To view all products from database: **/**
* To view one separated product from database: **/home-details/{id}**
* To see the page for developer, where you can manipulate with data: **/dev-section**
* To add new product by using POST request: **/dev-section/add**
* To view one separated product from database for developer with opportunity edit and delete: **/dev-section/{id}**
* To edit one separated product by using POST request: **/dev-section/{id}/edit**
* To delete one separated product by using POST request: **/dev-section/{id}/delete**
