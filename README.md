# I-media coding challenge

This application is a microservice  that manages products : 

  - Create, update and delete products
  - List all the products or single product
  - Rate the products..

The application is developed using Kotlin and  spring-boot, and built using Gradle.

# Rest web services :

  - POST : Add new product : /product
  - PUT : Upadte an existing product : /product
  - DELETE : Delete an existing product : /product/{productId}
  - GET : Get all the products : /product/all
  - GET : Get a single  products : /product/{productId}
  - POST :Rate a product : /product/{productId}/rating
  - GET : Get all products rating : /product/{productId}/ratings
  - PUT : Upadte an existing rating : /rating/{ratingId}
  - DELETE : Delete an existing rating : /rating/{ratingId} 
  - GET : Get rating : /rating/{ratingId}



# Building the application
### GIT
Clone the repository using git:
```sh
$ git clone https://github.com/Mohayas/imedia-challenge.git
```
Go to the application folder
```sh
$ cd imedia-challenge
```
### Gradel
Build the application with gradle
```sh
$ gradle build
```

### Docker
This challenge application is very easy to install and deploy in a Docker container.

 simply use the Dockerfile to build the image.

```sh
cd imedia-challenge
$ docker build -t challenge .
```
This will create the application image and pull in the necessary dependencies.

Once done, run the Docker image 

```sh
docker run  -p 8000:8080 challenge
```
# Test the application
To test the application here is  some mocked  json objects :

##### To create a product :
POST :  /product
{
"title": "title yy",
"subTitle": "hghgh",
"description": "Some desc here :)",
"price": 19.88,
"ratings": [
{"comment": "comment Posted","title": "title Posted","numberOfStars": 4}
],
"images": [
{"path": "path2"},
{"path": "path3"},
{"path": "path4"}]
}

##### To update product
PUT :  /product
{
"id": 1,
"title": "updated",
"subTitle": "kkkkk",
"description": "77777777777777777777777 :)",
"price": 787878787.77
}

##### To rate a product
POST :  /product/{some_productId_here}/rating
{
"comment": "comment Posted",
"title": "title Posted",
"numberOfStars": -8
}



