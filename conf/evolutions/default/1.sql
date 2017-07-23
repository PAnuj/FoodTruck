# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table food_truck_info (
  id                            bigint auto_increment not null,
  address                       varchar(255),
  applicant                     varchar(255),
  block                         varchar(255),
  blocklot                      varchar(255),
  cnn                           varchar(255),
  expirationdate                varchar(255),
  facilitytype                  varchar(255),
  fooditems                     varchar(255),
  latitude                      varchar(255),
  location                      varchar(255),
  locationdescription           varchar(255),
  longitude                     varchar(255),
  lot                           varchar(255),
  objectid                      varchar(255),
  permit                        varchar(255),
  priorpermit                   varchar(255),
  receive                       varchar(255),
  schedule                      varchar(255),
  stringstatus                  varchar(255),
  x                             varchar(255),
  y                             varchar(255),
  constraint pk_food_truck_info primary key (id)
);


# --- !Downs

drop table if exists food_truck_info;

