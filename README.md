[<img src="https://img.shields.io/travis/playframework/play-java-starter-example.svg"/>](https://travis-ci.org/playframework/play-java-starter-example)

# Play Java Starter

This is the backend codebase for food delivery trucks database. It contains a number of open source apis that are easily accessible for addition, deletion and updation of foodtruck. Information about foodtrucks mainly contains vendor name, foodtruck location, perimit and expiry date of license.

## Usage
Apis can be used by making http call through Postmnan or browser.

## API Overview

### add a new foodtruck (POST)

> API End Point
- http://34.211.56.46:9900/myGate/foodTruck/add

> Request Body (Json)
```
{":@computed_region_bh8s_q3mv":"28853",":@computed_region_fyvs_ahh9":"34",":@computed_region_p5aj_wyqh":"2",":@computed_region_rxqg_mtj9":"9",":@computed_region_yftq_j783":"8","address":"1301 MARKET ST","applicant":"HALAL SF GYRO","approved":"2017-02-10T00:00:00.000","block":"3508","blocklot":"3508001","cnn":"8753101","dayshours":"Th/Fr/Sa:6AM-4PM","expirationdate":"2018-03-15T00:00:00.000","facilitytype":"Push Cart","fooditems":"Gyro Sandwich: Chicken Sandwich: Lamb over rice: chicken over rice: fish sandwich & fish over rice","latitude":"37.7767362127501","location":{"type":"Point","coordinates":[-122.416395,37.776736]},"locationdescription":"MARKET ST: 09TH ST \\ LARKIN ST to 10TH ST \\ FELL ST \\ POLK ST (1301 - 1399) -- SOUTH --","longitude":"-122.416394930077","lot":"001","objectid":"719121","permit":"15MFF-0138","priorpermit":"0","received":"2015-07-31","schedule":"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=15MFF-0138&ExportPDF=1&Filename=15MFF-0138_schedule.pdf","status":"APPROVED","x":"6007839.137","y":"2110959.852"}
```
> Response 
```
some text information
```

### get all expired licences for upto given date (GET)

> API End Point
- http://34.211.56.46:9900/myGate/foodTRruck/expiredpermit?date=2019:09:11T11:21:23

> Request Body
```
date=2019:09:11T11:21:23
```
> Response
```
[{"id":1,"address":"2450 TARAVAL ST","applicant":"Swell Cream & Coffee","block":"2363","blocklot":"2363022","cnn":"12410000","expirationdate":"2018-01-30T00:00:00.000","facilitytype":"Truck","fooditems":"Ice cream: coffee: pastries","latitude":"37.7425503735592","location":"{\"type\":\"Point\",\"coordinates\":[-122.492677,37.74255]}","locationdescription":"TARAVAL ST: 34TH AVE to 35TH AVE (2400 - 2499)","longitude":"-122.492677082215","lot":"022","objectid":"931094","permit":"17MFF-0002","priorpermit":"0","receive":"2017-01-30","schedule":"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule¶ms=permit=17MFF-0002&ExportPDF=1&Filename=17MFF-0002_schedule.pdf","x":"5985532.259","y":"2098975.331","stringstatus":"REQUESTED"},{"id":2,"address":"2450 TARAVAL ST","applicant":"Swell Cream & Coffee","block":"2363","blocklot":"2363022","cnn":"12410000","expirationdate":"2018-01-30T00:00:00.000","facilitytype":"Truck","fooditems":"Ice cream: coffee: pastries","latitude":"37.7425503735592","location":"{\"type\":\"Point\",\"coordinates\":[-122.492677,37.74255]}","locationdescription":"TARAVAL ST: 34TH AVE to 35TH AVE (2400 - 2499)","longitude":"-122.492677082215","lot":"022","objectid":"931094","permit":"17MFF-0002","priorpermit":"0","receive":"2017-01-30","schedule":"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule¶ms=permit=17MFF-0002&ExportPDF=1&Filename=17MFF-0002_schedule.pdf","x":"5985532.259","y":"2098975.331","stringstatus":null},{"id":3,"address":"300 CALIFORNIA ST","applicant":"Breaking Bread Inc.","block":"0238","blocklot":"0238002","cnn":"2754000","expirationdate":"2018-03-15T00:00:00.000","facilitytype":"Truck","fooditems":"prepackaged food","latitude":"37.7934465278161","location":"{\"type\":\"Point\",\"coordinates\":[-122.400344,37.793447]}","locationdescription":"BATTERY ST: CALIFORNIA ST to HALLECK ST (200 - 230)","longitude":"-122.400343675592","lot":"002","objectid":"934995","permit":"17MFF-0124","priorpermit":"0","receive":"2017-02-14","schedule":"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule¶ms=permit=17MFF-0124&ExportPDF=1&Filename=17MFF-0124_schedule.pdf","x":"6012600.766","y":"2116948.597","stringstatus":null},{"id":4,"address":"1390 MARKET ST","applicant":"HALAL SF GYRO","block":"0813","blocklot":"0813007","cnn":"8753201","expirationdate":"2018-03-15T00:00:00.000","facilitytype":"Push Cart","fooditems":"Gyro Sandwich: Chicken Sandwich: Lamb over rice: chicken over rice: fish sandwich & fish over rice","latitude":"37.7772235984329","location":"{\"type\":\"Point\",\"coordinates\":[-122.417361,37.777224]}","locationdescription":"MARKET ST: 09TH ST \\ LARKIN ST to 10TH ST \\ FELL ST \\ POLK ST (1300 - 1398) -- NORTH --","longitude":"-122.417361361253","lot":"007","objectid":"719119","permit":"15MFF-0138","priorpermit":"0","receive":"2015-07-31","schedule":"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule¶ms=permit=15MFF-0138&ExportPDF=1&Filename=15MFF-0138_schedule.pdf","x":"6007563.51849","y":"2111143.00298","stringstatus":null},{"id":5,"address":"1301 MARKET ST","applicant":"HALAL SF GYRO","block":"3508","blocklot":"3508001","cnn":"8753101","expirationdate":"2018-03-15T00:00:00.000","facilitytype":"Push Cart","fooditems":"Gyro Sandwich: Chicken Sandwich: Lamb over rice: chicken over rice: fish sandwich & fish over rice","latitude":"37.7767362127501","location":"{\"type\":\"Point\",\"coordinates\":[-122.416395,37.776736]}","locationdescription":"MARKET ST: 09TH ST \\ LARKIN ST to 10TH ST \\ FELL ST \\ POLK ST (1301 - 1399) -- SOUTH --","longitude":"-122.416394930077","lot":"001","objectid":"719121","permit":"15MFF-0138","priorpermit":"0","receive":"2015-07-31","schedule":"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule¶ms=permit=15MFF-0138&ExportPDF=1&Filename=15MFF-0138_schedule.pdf","x":"6007839.137","y":"2110959.852","stringstatus":null},{"id":6,"address":"1301 MARKET ST","applicant":"HALAL SF GYRO","block":"3508","blocklot":"3508001","cnn":"8753101","expirationdate":"2018-03-15T00:00:00.000","facilitytype":"Push Cart","fooditems":"Gyro Sandwich: Chicken Sandwich: Lamb over rice: chicken over rice: fish sandwich & fish over rice","latitude":"37.7767362127501","location":"{\"type\":\"Point\",\"coordinates\":[-122.416395,37.776736]}","locationdescription":"MARKET ST: 09TH ST \\ LARKIN ST to 10TH ST \\ FELL ST \\ POLK ST (1301 - 1399) -- SOUTH --","longitude":"-122.416394930077","lot":"001","objectid":"719121","permit":"15MFF-0138","priorpermit":"0","receive":"2015-07-31","schedule":"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule¶ms=permit=15MFF-0138&ExportPDF=1&Filename=15MFF-0138_schedule.pdf","x":"6007839.137","y":"2110959.852","stringstatus":null}]
```

### get a foodtruck by street name (GET)

> API End Point 
- http://34.211.56.46:9900/myGate/foodTruck/byStreetName?streetName=MARKET ST

> Request
streetName=_some text from street name_

> Response
```
[{"id":4,"address":"1390 MARKET ST","applicant":"HALAL SF GYRO","block":"0813","blocklot":"0813007","cnn":"8753201","expirationdate":"2018-03-15T00:00:00.000","facilitytype":"Push Cart","fooditems":"Gyro Sandwich: Chicken Sandwich: Lamb over rice: chicken over rice: fish sandwich & fish over rice","latitude":"37.7772235984329","location":"{\"type\":\"Point\",\"coordinates\":[-122.417361,37.777224]}","locationdescription":"MARKET ST: 09TH ST \\ LARKIN ST to 10TH ST \\ FELL ST \\ POLK ST (1300 - 1398) -- NORTH --","longitude":"-122.417361361253","lot":"007","objectid":"719119","permit":"15MFF-0138","priorpermit":"0","receive":"2015-07-31","schedule":"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule¶ms=permit=15MFF-0138&ExportPDF=1&Filename=15MFF-0138_schedule.pdf","x":"6007563.51849","y":"2111143.00298","stringstatus":null},{"id":5,"address":"1301 MARKET ST","applicant":"HALAL SF GYRO","block":"3508","blocklot":"3508001","cnn":"8753101","expirationdate":"2018-03-15T00:00:00.000","facilitytype":"Push Cart","fooditems":"Gyro Sandwich: Chicken Sandwich: Lamb over rice: chicken over rice: fish sandwich & fish over rice","latitude":"37.7767362127501","location":"{\"type\":\"Point\",\"coordinates\":[-122.416395,37.776736]}","locationdescription":"MARKET ST: 09TH ST \\ LARKIN ST to 10TH ST \\ FELL ST \\ POLK ST (1301 - 1399) -- SOUTH --","longitude":"-122.416394930077","lot":"001","objectid":"719121","permit":"15MFF-0138","priorpermit":"0","receive":"2015-07-31","schedule":"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule¶ms=permit=15MFF-0138&ExportPDF=1&Filename=15MFF-0138_schedule.pdf","x":"6007839.137","y":"2110959.852","stringstatus":null},{"id":6,"address":"1301 MARKET ST","applicant":"HALAL SF GYRO","block":"3508","blocklot":"3508001","cnn":"8753101","expirationdate":"2018-03-15T00:00:00.000","facilitytype":"Push Cart","fooditems":"Gyro Sandwich: Chicken Sandwich: Lamb over rice: chicken over rice: fish sandwich & fish over rice","latitude":"37.7767362127501","location":"{\"type\":\"Point\",\"coordinates\":[-122.416395,37.776736]}","locationdescription":"MARKET ST: 09TH ST \\ LARKIN ST to 10TH ST \\ FELL ST \\ POLK ST (1301 - 1399) -- SOUTH --","longitude":"-122.416394930077","lot":"001","objectid":"719121","permit":"15MFF-0138","priorpermit":"0","receive":"2015-07-31","schedule":"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule¶ms=permit=15MFF-0138&ExportPDF=1&Filename=15MFF-0138_schedule.pdf","x":"6007839.137","y":"2110959.852","stringstatus":null}]
```

### get nearby foodtruck by latitude and longitude (GET) 

> API End Point 
- http://34.211.56.46:9900/myGate/foodTruck/nearByTruck?latitude=-122.416395&longitude=37.776736

> Request 
- latitude=-122.416395&longitude=37.776736

> Response
```
{
    "id": 5,
    "address": "1301 MARKET ST",
    "applicant": "HALAL SF GYRO",
    "block": "3508",
    "blocklot": "3508001",
    "cnn": "8753101",
    "expirationdate": "2018-03-15T00:00:00.000",
    "facilitytype": "Push Cart",
    "fooditems": "Gyro Sandwich: Chicken Sandwich: Lamb over rice: chicken over rice: fish sandwich & fish over rice",
    "latitude": "37.7767362127501",
    "location": "{\"type\":\"Point\",\"coordinates\":[-122.416395,37.776736]}",
    "locationdescription": "MARKET ST: 09TH ST \\ LARKIN ST to 10TH ST \\ FELL ST \\ POLK ST (1301 - 1399) -- SOUTH --",
    "longitude": "-122.416394930077",
    "lot": "001",
    "objectid": "719121",
    "permit": "15MFF-0138",
    "priorpermit": "0",
    "receive": "2015-07-31",
    "schedule": "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=15MFF-0138&ExportPDF=1&Filename=15MFF-0138_schedule.pdf",
    "x": "6007839.137",
    "y": "2110959.852",
    "stringstatus": null
}
```

### delete foodtruck by cnn (GET)
> API End Point
- http://34.211.56.46:9900/myGate/foodTruck/delete?cnn=235556

> Request
- cnn=_cnn of food truck_

> Response 
- _some text showing delete status_

### find foodtruck by applciant name (GET)
> API End Point
- http://34.211.56.46:9900/myGate/foodTruck/byApplicant?applicantName=Swell Cream & Coffee

> Request 
- applicantName=_some apllicant name_

> Response 
```
{
        "id": 1,
        "address": "2450 TARAVAL ST",
        "applicant": "Swell Cream & Coffee",
        "block": "2363",
        "blocklot": "2363022",
        "cnn": "12410000",
        "expirationdate": "2018-01-30T00:00:00.000",
        "facilitytype": "Truck",
        "fooditems": "Ice cream: coffee: pastries",
        "latitude": "37.7425503735592",
        "location": "{\"type\":\"Point\",\"coordinates\":[-122.492677,37.74255]}",
        "locationdescription": "TARAVAL ST: 34TH AVE to 35TH AVE (2400 - 2499)",
        "longitude": "-122.492677082215",
        "lot": "022",
        "objectid": "931094",
        "permit": "17MFF-0002",
        "priorpermit": "0",
        "receive": "2017-01-30",
        "schedule": "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=17MFF-0002&ExportPDF=1&Filename=17MFF-0002_schedule.pdf",
        "x": "5985532.259",
        "y": "2098975.331",
        "stringstatus": "REQUESTED"
    },
```

### update all food truck i.e. mark their licences expired if their date of expiration has crossed the current date

> API End Point
- http://34.211.56.46:9900/myGate/foodTruck/checkLicence 

> Request
- nothing

> Response
- _response showing status of api call_







