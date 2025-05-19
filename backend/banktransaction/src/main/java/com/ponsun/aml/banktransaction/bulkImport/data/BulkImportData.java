package com.ponsun.aml.banktransaction.bulkImport.data;


import lombok.Data;

@Data
public class BulkImportData {
    private Integer pid;
    private Integer typeId;
    private Integer listOfPrefix;
    private String name;
    private String aliases1;
    private String aliases2;
    private String aliases3;
    private String aliases4;
    private String aliases5;
    private String aliases6;
    private String aliases7;
    private String aliases8;
    private String aliases9;
    private String aliases10;
    private String aliases11;
    private String aliases12;
    private String aliases13;
    private String aliases14;
    private String aliases15;
    private String aliases16;
    private String aliases17;
    private String aliases18;
    private String aliases19;
    private String aliases20;
    private String aliases21;
    private String aliases22;
    private String aliases23;
    private String aliases24;
    private String aliases25;
    private String familyName;
    private String forename;
    private String gender;
    private Integer stateid1;
    private Integer stateid2;
    private Integer stateid3;
    private Integer stateid4;
    private Integer stateid5;
    private Integer stateid6;
    private String dateOfBirth;
    private Integer stateid7;
    private Integer stateid8;
    private Integer stateid9;
    private Integer stateid10;
    private String nationality;
    private String passportNumber;
    private String panNumber;
    private String aadharNumber;
    private String dinNumber;
    private String cinNumber;
    private String drivinglicenseNumber;
    private String companyName;
    private String designation;
    private String place;
    private String otherDetailsAboutCompany;
    private String fatherName;
    private String listofFatherAliasesName;
    private String otherDetailsAboutFather;
    private String motherName;
    private String listofMotherAliasesName;
    private String otherDetailsAboutMother;
    private String spouseName;
    private String listofSpouseAliasesName;
    private String otherDetailsAboutSpouse;
    private String childrenName;
    private String listofChildrenAliasesName;
    private String otherDetailsAboutChildren;
    private String otherRelativesName;
    private String listofOtherRelativesAliasesName;
    private String otherDetailsAboutRelatives;
    private String placeofDisappearance;
    private String dateofDisappearance;
    private String sourceLink;
    private String listOfAddress;
    private String listofPlaceofBirth;
    private String caseDetails;
    private String listofSectionofLaw;
    private String accusedStatus;
    private String listofLinkedOrganizationName;
    private String listofLinkedOrganizationNameAliases;
    private String summaryOfAllegation;
    private String distingushingMarksAndCharacteristics;
    private String extraInformation;
    private String lisofLinkedCriminalIndividuals;

    public BulkImportData
            (final Integer typeId , final Integer listOfPrefix ,final String name, final String aliases1,final String aliases2,final String aliases3 ,final String aliases4,final String aliases5,final String aliases6, final String aliases7,final String aliases8,final String aliases9,final String aliases10,final String aliases11,final String aliases12,final String aliases13,final String aliases14,final String aliases15,final String aliases16,final String aliases17,final String aliases18,final String aliases19,final String aliases20,final String aliases21,final String aliases22,final String aliases23,final String aliases24,final String aliases25,final String familyName,final String forename,final String gender , final Integer stateid1,final Integer stateid2,final Integer stateid3,final Integer stateid4,final Integer stateid5,final Integer stateid6,final String dateOfBirth,final Integer stateid7,final Integer stateid8,final Integer stateid9,final Integer stateid10,final String nationality,final String passportNumber,final String panNumber,final String aadharNumber,final String dinNumber,
             final String cinNumber,final String drivinglicenseNumber , final String companyName , final String designation , final String place , final String otherDetailsAboutCompany ,
             final  String fatherName , final String listofFatherAliasesName , final String otherDetailsAboutFather,
             final String motherName , final String listofMotherAliasesName, final String otherDetailsAboutMother , final String spouseName , final String listofSpouseAliasesName , final String otherDetailsAboutSpouse ,
             final String childrenName , final String listofChildrenAliasesName , final String otherDetailsAboutChildren , final  String otherRelativesName , final String listofOtherRelativesAliasesName,
             final String otherDetailsAboutRelatives , final String placeofDisappearance , final String dateofDisappearance , final String sourceLink ,
             final String listOfAddress , final String listofPlaceofBirth , final String caseDetails , final String listofSectionofLaw , final String accusedStatus , final String listofLinkedOrganizationName ,
             final String listofLinkedOrganizationNameAliases , final String summaryOfAllegation , final String distingushingMarksAndCharacteristics , final String extraInformation ,
             final String lisofLinkedCriminalIndividuals){
        this.typeId = typeId;
        this.listOfPrefix = listOfPrefix;
        this.name = name;
        this.aliases1 = aliases1;
        this.aliases2 = aliases2;
        this.aliases3 = aliases3;
        this.aliases4 = aliases4;
        this.aliases5 = aliases5;
        this.aliases6 = aliases6;
        this.aliases7 = aliases7;
        this.aliases8 = aliases8;
        this.aliases9 = aliases9;
        this.aliases10 = aliases10;
        this.aliases11 = aliases11;
        this.aliases12 = aliases12;
        this.aliases13 = aliases13;
        this.aliases14 = aliases14;
        this.aliases15 = aliases15;
        this.aliases17 = aliases17;
        this.aliases18 = aliases18;
        this.aliases19 = aliases19;
        this.aliases20 = aliases20;
        this.aliases21 = aliases21;
        this.aliases22 = aliases22;
        this.aliases23 = aliases23;
        this.aliases24 = aliases24;
        this.aliases25 = aliases25;
        this.familyName = familyName;
        this.forename = forename;
        this.gender = gender;
        this.stateid1 = stateid1;
        this.stateid2 = stateid2;
        this.stateid3 = stateid3;
        this.stateid4 = stateid4;
        this.stateid5 = stateid5;
        this.stateid6 = stateid6;
        this.dateOfBirth = dateOfBirth;
        this.stateid7 = stateid7;
        this.stateid8 = stateid8;
        this.stateid9 = stateid9;
        this.stateid10 = stateid10;
        this.nationality = nationality;
        this.passportNumber = passportNumber;
        this.panNumber = panNumber;
        this.aadharNumber = aadharNumber;
        this.dinNumber = dinNumber;
        this.cinNumber = cinNumber;
        this.drivinglicenseNumber = drivinglicenseNumber;
        this.companyName = companyName;
        this.designation = designation;
        this.place = place;
        this.otherDetailsAboutCompany = otherDetailsAboutCompany;
        this.fatherName = fatherName;
        this.listofFatherAliasesName = listofFatherAliasesName;
        this.otherDetailsAboutFather = otherDetailsAboutFather;
        this.motherName = motherName;
        this.listofMotherAliasesName = listofMotherAliasesName;
        this.otherDetailsAboutMother = otherDetailsAboutMother;
        this.childrenName = childrenName;
        this.listofChildrenAliasesName = listofChildrenAliasesName;
        this.otherDetailsAboutChildren = otherDetailsAboutChildren;
        this.otherRelativesName = otherRelativesName;
        this.listofOtherRelativesAliasesName = listofOtherRelativesAliasesName;
        this.otherDetailsAboutRelatives = otherDetailsAboutRelatives;
        this.placeofDisappearance = placeofDisappearance;
        this.dateofDisappearance = dateofDisappearance;
        this.sourceLink = sourceLink;
        this.listOfAddress = listOfAddress;
        this.listofPlaceofBirth = listofPlaceofBirth;
        this.listofSectionofLaw = listofSectionofLaw;
        this.accusedStatus = accusedStatus;
        this.listofLinkedOrganizationName = listofLinkedOrganizationName;
        this.listofLinkedOrganizationNameAliases = listofLinkedOrganizationNameAliases;
        this.summaryOfAllegation = summaryOfAllegation;
        this.distingushingMarksAndCharacteristics = distingushingMarksAndCharacteristics;
        this.extraInformation = extraInformation;
        this.lisofLinkedCriminalIndividuals = lisofLinkedCriminalIndividuals;
    }
public static BulkImportData newInstance (final Integer typeId , final Integer listOfPrefix ,final String name, final String aliases1,final String aliases2,final String aliases3 ,final String aliases4,final String aliases5,final String aliases6, final String aliases7,final String aliases8,final String aliases9,final String aliases10,final String aliases11,final String aliases12,final String aliases13,final String aliases14,final String aliases15,final String aliases16,final String aliases17,final String aliases18,final String aliases19,final String aliases20,final String aliases21,final String aliases22,final String aliases23,final String aliases24,final String aliases25,final String familyName,final String forename,final String gender , final Integer stateid1,final Integer stateid2,final Integer stateid3,final Integer stateid4,final Integer stateid5,final Integer stateid6,final String dateOfBirth,final Integer stateid7,final Integer stateid8,final Integer stateid9,final Integer stateid10,final String nationality,final String passportNumber,final String panNumber,final String aadharNumber,final String dinNumber,
                                          final String cinNumber,final String drivinglicenseNumber , final String companyName , final String designation , final String place , final String otherDetailsAboutCompany ,
                                          final  String fatherName , final String listofFatherAliasesName , final String otherDetailsAboutFather,
                                          final String motherName , final String listofMotherAliasesName, final String otherDetailsAboutMother , final String spouseName , final String listofSpouseAliasesName , final String otherDetailsAboutSpouse ,
                                          final String childrenName , final String listofChildrenAliasesName , final String otherDetailsAboutChildren , final  String otherRelativesName , final String listofOtherRelativesAliasesName,
                                          final String otherDetailsAboutRelatives , final String placeofDisappearance , final String dateofDisappearance , final String sourceLink ,
                                          final String listOfAddress , final String listofPlaceofBirth , final String caseDetails , final String listofSectionofLaw , final String accusedStatus , final String listofLinkedOrganizationName ,
                                          final String listofLinkedOrganizationNameAliases , final String summaryOfAllegation , final String distingushingMarksAndCharacteristics , final String extraInformation ,
                                          final String lisofLinkedCriminalIndividuals){
        return new BulkImportData(typeId,listOfPrefix, name,aliases1,aliases2,aliases3 ,aliases4,aliases5,aliases6,aliases7,aliases8,aliases9,aliases10,aliases11,aliases12,aliases13,aliases14,aliases15,aliases16,aliases17,aliases18,aliases19,aliases20,aliases21,aliases22,aliases23,aliases24,aliases25,familyName,forename,gender,stateid1,stateid2,stateid3,stateid4,stateid5,stateid6,dateOfBirth,stateid7,stateid8,stateid9,stateid10,nationality,passportNumber,panNumber,aadharNumber,dinNumber,cinNumber,drivinglicenseNumber,companyName,designation,place,otherDetailsAboutCompany,fatherName,listofFatherAliasesName,otherDetailsAboutFather,motherName,listofMotherAliasesName,otherDetailsAboutMother,spouseName,listofSpouseAliasesName,otherDetailsAboutSpouse,childrenName,listofChildrenAliasesName,otherDetailsAboutChildren,otherRelativesName,listofOtherRelativesAliasesName,otherDetailsAboutRelatives,placeofDisappearance,dateofDisappearance,sourceLink,listOfAddress,listofPlaceofBirth,caseDetails,listofSectionofLaw,accusedStatus,listofLinkedOrganizationName,listofLinkedOrganizationNameAliases,summaryOfAllegation,distingushingMarksAndCharacteristics,extraInformation,lisofLinkedCriminalIndividuals);
                                          }

}
