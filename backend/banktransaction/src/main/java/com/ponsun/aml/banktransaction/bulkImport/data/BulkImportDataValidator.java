package com.ponsun.aml.banktransaction.bulkImport.data;

import com.ponsun.aml.banktransaction.bulkImport.request.CreateBulkImportRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.naming.Name;

@Slf4j
@Service
public class BulkImportDataValidator {
    public void validateSaveBulkImport(final CreateBulkImportRequest request) {
//            if(request.getName() == null || request.getName().equals("")){
//                throw new CrmAppicationException("Name parameter required");
//            }
//          }
//}
//            final Name fName = this.bulkImportRepositoryWrapper.findOneWithName(Name);
        if (request.getSender() != null) {
            System.out.println("fName already Exists " + request.getSender());
            log.debug("fName already Exists  {} ", request.getSender());
//                continue;
        }
//            final TypeId type = this.bulkImportRepositoryWrapper.findOneWithType(TypeId);
        if (request.getReceiver() != null) {
            System.out.println("type already Exists" + request.getReceiver());
            log.debug("type already Exists {}", request.getReceiver());
//                continue;
        }
//            final SourceLink sourceLink = this.bulkImportRepositoryWrapper.findOneWithSourceLink(SourceLink);
//            if (sourceLink != null) {
//                System.out.println("SourceLink already Exists" + sourceLink.getSourceLink());
//                log.debug("SourceLink already Exists {}", sourceLink.getSourceLink());
//                continue;
//            }
////            final ListOfPrefix listOfPrefix = this.bulkImportRepositoryWrapper.findOneWithListOfPrefix(ListOfPrefix);
//            if (listOfPrefix != null) {
//                System.out.println("SourceLink already Exists" + listOfPrefix.getListOfPrefix());
//                log.debug("SourceLink already Exists {}", listOfPrefix.getListOfPrefix());
//                continue;
//            }
//            final Aliases1 aliases1 = this.bulkImportRepositoryWrapper.findOneWithAliases1(Aliases1);
//            if (aliases1 != null) {
//                System.out.println("Aliases1 already Exists" + aliases1.getAliases1());
//                log.debug("Aliases1 already Exists {}", aliases1.getAliases1());
//                continue;
//            }
//            final Aliases2 aliases2 = this.bulkImportRepositoryWrapper.findOneWithAliases2(Aliases2);
//            if (aliases2 != null) {
//                System.out.println("Aliases2 already Exists" + aliases2.getAliases2());
//                log.debug("Aliases2 already Exists {}", aliases2.getAliases2());
//                continue;
//            }
//            final Aliases3 aliases3 = this.bulkImportRepositoryWrapper.findOneWithAliases3(Aliases3);
//            if (aliases3 != null) {
//                System.out.println("Aliases3 already Exists" + aliases3.getAliases3());
//                log.debug("Aliases3 already Exists {}", aliases3.getAliases3());
//                continue;
//            }
//            final Aliases4 aliases4 = this.bulkImportRepositoryWrapper.findOneWithAliases4(Aliases4);
//            if (aliases4 != null) {
//                System.out.println("Aliases4 already Exists" + aliases4.getAliases4());
//                log.debug("Aliases4 already Exists {}", aliases4.getAliases4());
//                continue;
//            }
//            final Aliases5 aliases5 = this.bulkImportRepositoryWrapper.findOneWithAliases5(Aliases5);
//            if (aliases5 != null) {
//                System.out.println("Aliases5 already Exists" + aliases5.getAliases5());
//                log.debug("Aliases5 already Exists {}", aliases5.getAliases5());
//                continue;
//            }
//            final Aliases6 aliases6 = this.bulkImportRepositoryWrapper.findOneWithAliases6(Aliases6);
//            if (aliases6 != null) {
//                System.out.println("Aliases6 already Exists" + aliases6.getAliases6());
//                log.debug("Aliases6 already Exists {}", aliases6.getAliases6());
//                continue;
//            }
//            final Aliases7 aliases7 = this.bulkImportRepositoryWrapper.findOneWithAliases7(Aliases7);
//            if (aliases7 != null) {
//                System.out.println("Aliases7 already Exists" + aliases7.getAliases7());
//                log.debug("Aliases7 already Exists {}", aliases7.getAliases7());
//                continue;
//            }
//            final Aliases8 aliases8 = this.bulkImportRepositoryWrapper.findOneWithAliases8(Aliases8);
//            if (aliases8 != null) {
//                System.out.println("Aliases8 already Exists" + aliases8.getAliases8());
//                log.debug("Aliases8 already Exists {}", aliases8.getAliases8());
//                continue;
//            }
//            final Aliases9 aliases9 = this.bulkImportRepositoryWrapper.findOneWithAliases9(Aliases9);
//            if (aliases9 != null) {
//                System.out.println("Aliases9 already Exists" + aliases9.getAliases9());
//                log.debug("Aliases9 already Exists {}", aliases9.getAliases9());
//                continue;
//            }
//            final Aliases10 aliases10 = this.bulkImportRepositoryWrapper.findOneWithAliases10(Aliases10);
//            if (aliases10 != null) {
//                System.out.println("Aliases10 already Exists" + aliases10.getAliases10());
//                log.debug("Aliases10 already Exists {}", aliases10.getAliases10());
//                continue;
//            }
//            final Aliases11 aliases11 = this.bulkImportRepositoryWrapper.findOneWithAliases11(Aliases11);
//            if (aliases11 != null) {
//                System.out.println("Aliases11 already Exists" + aliases11.getAliases11());
//                log.debug("Aliases11 already Exists {}", aliases11.getAliases11());
//                continue;
//            }
//            final Aliases12 aliases12 = this.bulkImportRepositoryWrapper.findOneWithAliases12(Aliases12);
//            if (aliases12 != null) {
//                System.out.println("Aliases12 already Exists" + aliases12.getAliases12());
//                log.debug("Aliases12 already Exists {}", aliases12.getAliases12());
//                continue;
//            }
//            final Aliases13 aliases13 = this.bulkImportRepositoryWrapper.findOneWithAliases13(Aliases13);
//            if (aliases13 != null) {
//                System.out.println("Aliases13 already Exists" + aliases13.getAliases13());
//                log.debug("Aliases13 already Exists {}", aliases13.getAliases13());
//                continue;
//            }
//            final Aliases14 aliases14 = this.bulkImportRepositoryWrapper.findOneWithAliases14(Aliases14);
//            if (aliases14 != null) {
//                System.out.println("Aliases14 already Exists" + aliases14.getAliases14());
//                log.debug("Aliases14 already Exists {}", aliases14.getAliases14());
//                continue;
//            }
//            final Aliases15 aliases15 = this.bulkImportRepositoryWrapper.findOneWithAliases15(Aliases15);
//            if (aliases15 != null) {
//                System.out.println("Aliases15 already Exists" + aliases15.getAliases15());
//                log.debug("Aliases15 already Exists {" +
//                        "}", aliases15.getAliases15());
//                continue;
//            }
//            final Aliases16 aliases16 = this.bulkImportRepositoryWrapper.findOneWithAliases16(Aliases16);
//            if (aliases16 != null) {
//                System.out.println("Aliases16 already Exists" + aliases16.getAliases16());
//                log.debug("Aliases16 already Exists {}", aliases16.getAliases16());
//                continue;
//            }
//            final Aliases17 aliases17 = this.bulkImportRepositoryWrapper.findOneWithAliases17(Aliases17);
//            if (aliases17 != null) {
//                System.out.println("Aliases17 already Exists" + aliases17.getAliases17());
//                log.debug("Aliases17 already Exists {}", aliases17.getAliases17());
//                continue;
//            }
//            final Aliases18 aliases18 = this.bulkImportRepositoryWrapper.findOneWithAliases18(Aliases18);
//            if (aliases18 != null) {
//                System.out.println("Aliases18 already Exists" + aliases18.getAliases18());
//                log.debug("Aliases18 already Exists {}", aliases18.getAliases18());
//                continue;
//            }
//            final Aliases19 aliases19 = this.bulkImportRepositoryWrapper.findOneWithAliases19(Aliases19);
//            if (aliases19 != null) {
//                System.out.println("Aliases19 already Exists" + aliases19.getAliases19());
//                log.debug("Aliases19 already Exists {}", aliases19.getAliases19());
//                continue;
//            }
//            final Aliases20 aliases20 = this.bulkImportRepositoryWrapper.findOneWithAliases20(Aliases20);
//            if (aliases20 != null) {
//                System.out.println("Aliases20 already Exists" + aliases20.getAliases20());
//                log.debug("Aliases20 already Exists {}", aliases20.getAliases20());
//                continue;
//            }
//            final Aliases21 aliases21 = this.bulkImportRepositoryWrapper.findOneWithAliases21(Aliases21);
//            if (aliases21 != null) {
//                System.out.println("Aliases21 already Exists" + aliases21.getAliases21());
//                log.debug("Aliases21 already Exists {}", aliases21.getAliases21());
//                continue;
//            }
//            final Aliases22 aliases22 = this.bulkImportRepositoryWrapper.findOneWithAliases22(Aliases22);
//            if (aliases22 != null) {
//                System.out.println("Aliases22 already Exists" + aliases22.getAliases22());
//                log.debug("Aliases22 already Exists {}", aliases22.getAliases22());
//                continue;
//            }
//            final Aliases23 aliases23 = this.bulkImportRepositoryWrapper.findOneWithAliases23(Aliases23);
//            if (aliases23 != null) {
//                System.out.println("Aliases23 already Exists" + aliases23.getAliases23());
//                log.debug("Aliases23 already Exists {}", aliases23.getAliases23());
//                continue;
//            }
//            final Aliases24 aliases24 = this.bulkImportRepositoryWrapper.findOneWithAliases24(Aliases24);
//            if (aliases24 != null) {
//                System.out.println("Aliases24 already Exists" + aliases24.getAliases24());
//                log.debug("Aliases24 already Exists {}", aliases24.getAliases24());
//                continue;
//            }
//            final Aliases25 aliases25 = this.bulkImportRepositoryWrapper.findOneWithAliases25(Aliases25);
//            if (aliases25 != null) {
//                System.out.println("Aliases25 already Exists" + aliases25.getAliases25());
//                log.debug("Aliases25 already Exists {}", aliases25.getAliases25());
//                continue;
//            }
//            final FamilyName familyName = this.bulkImportRepositoryWrapper.findOneWithFamilyName(FamilyName);
//            if (familyName != null) {
//                System.out.println("FamilyName already Exists" + FamilyName.getFamilyName());
//                log.debug("FamilyName already Exists {}", FamilyName.getFamilyName());
//                continue;
//            }
//            final Forename forename = this.bulkImportRepositoryWrapper.findOneWithForename(Forename);
//            if (forename != null) {
//                System.out.println("Forename already Exists" + FamilyName.getForename());
//                log.debug("Forename already Exists {}", FamilyName.getForename());
//                continue;
//            }
//            final Gender gender = this.bulkImportRepositoryWrapper.findOneWithGender(Gender);
//            if (gender != null) {
//                System.out.println("Gender already Exists" + FamilyName.getGender());
//                log.debug("Gender already Exists {}", FamilyName.getGender());
//                continue;
//            }
//            final ListOfAddress listOfAddress = this.bulkImportRepositoryWrapper.findOneWithListOfAddress(ListOfAddress);
//            if (listOfAddress != null) {
//                System.out.println("ListOfAddress already Exists" + ListOfAddress.getListOfAddress());
//                log.debug("ListOfAddress already Exists {}", ListOfAddress.getListOfAddress());
//                continue;
//            }
//            final State1 state1 = this.bulkImportRepositoryWrapper.findOneWithState1(State1);
//            if (state1 != null) {
//                System.out.println("State1 already Exists" + State1.getState1());
//                log.debug("State1 already Exists {}", State1.getState1());
//                continue;
//            }
//            final State2 state2 = this.bulkImportRepositoryWrapper.findOneWithState2(State2);
//            if (state2 != null) {
//                System.out.println("State2 already Exists" + State2.getState2());
//                log.debug("State2 already Exists {}", State2.getState2());
//                continue;
//            }
//            final State3 state3 = this.bulkImportRepositoryWrapper.findOneWithState3(State3);
//            if (state3 != null) {
//                System.out.println("State3 already Exists" + State3.getState3());
//                log.debug("State3 already Exists {}", State3.getState3());
//                continue;
//            }
//            final State4 state4 = this.bulkImportRepositoryWrapper.findOneWithState4(State4);
//            if (state4 != null) {
//                System.out.println("State4 already Exists" + State4.getState4());
//                log.debug("State4 already Exists {}", State4.getState4());
//                continue;
//            }
//            final State5 state5 = this.bulkImportRepositoryWrapper.findOneWithState5(State5);
//            if (state5 != null) {
//                System.out.println("State5 already Exists" + State5.getState5());
//                log.debug("State5 already Exists {}", State5.getState5());
//                continue;
//            }
//            final State6 state6 = this.bulkImportRepositoryWrapper.findOneWithState6(State6);
//            if (state6 != null) {
//                System.out.println("State6 already Exists" + State6.getState6());
//                log.debug("State6 already Exists {}", State6.getState6());
//                continue;
//            }
//            final DateOfBirth dateOfBirth = this.bulkImportRepositoryWrapper.findOneWithDateOfBirth(DateOfBirth);
//            if (dateOfBirth != null) {
//                System.out.println("DateOfBirth already Exists" + dateOfBirth.getDateOfBirth());
//                log.debug("DateOfBirth already Exists {}", dateOfBirth.getDateOfBirth());
//                continue;
//            }
//            final ListOfPlaceOfBirth listOfPlaceOfBirth = this.bulkImportRepositoryWrapper.findOneWithListOfPlaceOfBirth(ListOfPlaceOfBirth);
//            if (listOfPlaceOfBirth != null) {
//                System.out.println("ListOfPlaceOfBirth already Exists" + listOfPlaceOfBirth.getListOfPlaceOfBirth());
//                log.debug("ListOfPlaceOfBirth already Exists {}", listOfPlaceOfBirth.getListOfPlaceOfBirth());
//                continue;
//            }
//
//            final State7 state7 = this.bulkImportRepositoryWrapper.findOneWithState7(State7);
//            if (state7 != null) {
//                System.out.println("State7 already Exists" + state7.getState7());
//                log.debug("State7 already Exists {}", state7.getState7());
//                continue;
//            }
//
//            final State8 state8 = this.bulkImportRepositoryWrapper.findOneWithState8(State8);
//            if (state8 != null) {
//                System.out.println("State8 already Exists" + state8.getState8());
//                log.debug("State8 already Exists {}", state8.getState8());
//                continue;
//            }
//            final State9 state9 = this.bulkImportRepositoryWrapper.findOneWithState9(State9);
//            if (state9 != null) {
//                System.out.println("State9 already Exists" + state9.getState9());
//                log.debug("State9 already Exists {}", state9.getState9());
//                continue;
//            }
//            final State10 state10 = this.bulkImportRepositoryWrapper.findOneWithState10(State10);
//            if (state10 != null) {
//                System.out.println("State10 already Exists" + state10.getState10());
//                log.debug("State10 already Exists {}", state10.getState10());
//                continue;
//            }
//            final Nationality nationality = this.bulkImportRepositoryWrapper.findOneWithNationality(Nationality);
//            if (nationality != null) {
//                System.out.println("Nationality already Exists" + nationality.getNationality());
//                log.debug("Nationality already Exists {}", nationality.getNationality());
//                continue;
//            }
//            final PassportNumber passportNumber = this.bulkImportRepositoryWrapper.findOneWithNationality(PassportNumber);
//            if (passportNumber != null) {
//                System.out.println("Nationality already Exists" + passportNumber.getPassportNumber());
//                log.debug("Nationality already Exists {}", passportNumber.getPassportNumber());
//                continue;
//            }
//            final PANNumber panNumber = this.bulkImportRepositoryWrapper.findOneWithPANNumber(PANNumber);
//            if (panNumber != null) {
//                System.out.println("PANNumber already Exists" + panNumber.getPANNumber());
//                log.debug("PANNumber already Exists {}", panNumber.getPANNumber());
//                continue;
//            }
//            final AadharNumber aadharNumber = this.bulkImportRepositoryWrapper.findOneWithAadharNumber(AadharNumber);
//            if (aadharNumber != null) {
//                System.out.println("AadharNumber already Exists" + aadharNumber.getAadharNumber());
//                log.debug("AadharNumber already Exists {}", aadharNumber.getAadharNumber());
//                continue;
//            }
//            final DINNumber dinNumber = this.bulkImportRepositoryWrapper.findOneWithDINNumber(DINNumber);
//            if (dinNumber != null) {
//                System.out.println("DINNumber already Exists" + dinNumber.getDINNumber());
//                log.debug("DINNumber already Exists {}", dinNumber.getDINNumber());
//                continue;
//            }
//            final CINNumber cinNumber = this.bulkImportRepositoryWrapper.findOneWithDINNumber(CINNumber);
//            if (cinNumber != null) {
//                System.out.println("CINNumber already Exists" + cinNumber.getCINNumber());
//                log.debug("CINNumber already Exists {}", cinNumber.getCINNumber());
//                continue;
//            }
//            final DrivingLicenseNumber drivingLicenseNumber = this.bulkImportRepositoryWrapper.findOneWithDrivingLicenseNumber(DrivingLicenseNumber);
//            if (drivingLicenseNumber != null) {
//                System.out.println("DrivingLicenseNumber already Exists" + drivingLicenseNumber.getDrivingLicenseNumber());
//                log.debug("DrivingLicenseNumber already Exists {}", drivingLicenseNumber.getDrivingLicenseNumber());
//                continue;
//            }
//            final CompanyName companyName = this.bulkImportRepositoryWrapper.findOneWithCompanyName(CompanyName);
//            if (companyName != null) {
//                System.out.println("CompanyName already Exists" + companyName.getCompanyName());
//                log.debug("CompanyName already Exists {}", companyName.getCompanyName());
//                continue;
//            }
//            final Designation designation = this.bulkImportRepositoryWrapper.findOneWithCompanyName(Designation);
//            if (designation != null) {
//                System.out.println("Designation already Exists" + designation.getDesignation());
//                log.debug("Designation already Exists {}", designation.getDesignation());
//                continue;
//            }
//            final Place place = this.bulkImportRepositoryWrapper.findOneWithPlace(Place);
//            if (place != null) {
//                System.out.println("Place already Exists" + place.getPlace());
//                log.debug("Place already Exists {}", place.getPlace());
//                continue;
//            }
//            final OtherDetailsAboutCompany otherDetailsAboutCompany = this.bulkImportRepositoryWrapper.findOneWithOtherDetailsAboutCompany(OtherDetailsAboutCompany);
//            if (otherDetailsAboutCompany != null) {
//                System.out.println("OtherDetailsAboutCompany already Exists" + otherDetailsAboutCompany.getOtherDetailsAboutCompany());
//                log.debug("OtherDetailsAboutCompany already Exists {}", otherDetailsAboutCompany.getOtherDetailsAboutCompany());
//                continue;
//            }
//            final FatherName fatherName = this.bulkImportRepositoryWrapper.findOneWithFatherName(FatherName);
//            if (fatherName != null) {
//                System.out.println("FatherName already Exists" + fatherName.getFatherName());
//                log.debug("FatherName already Exists {}", fatherName.getFatherName());
//                continue;
//            }
//            final ListOfFatherAliasesName listofFatherAliasesName = this.bulkImportRepositoryWrapper.findOneWithListOfFatherAliasesName(ListOfFatherAliasesName);
//            if (listofFatherAliasesName != null) {
//                System.out.println("ListOfFatherAliasesName already Exists" + listofFatherAliasesName.getListOfFatherAliasesName());
//                log.debug("ListOfFatherAliasesName already Exists {}", listofFatherAliasesName.getListOfFatherAliasesName());
//                continue;
//            }
//            final OtherDetailsAboutFather otherDetailsAboutFather = this.bulkImportRepositoryWrapper.findOneWithOtherDetailsAboutFather(OtherDetailsAboutFather);
//            if (otherDetailsAboutFather != null) {
//                System.out.println("OtherDetailsAboutFather already Exists" + otherDetailsAboutFather.getOtherDetailsAboutFather());
//                log.debug("OtherDetailsAboutFather already Exists {}", otherDetailsAboutFather.getOtherDetailsAboutFather());
//                continue;
//            }
//            final MotherName motherName = this.bulkImportRepositoryWrapper.findOneWithMotherName(OtherDetailsAboutFather);
//            if (motherName != null) {
//                System.out.println("MotherName already Exists" + motherName.getMotherName());
//                log.debug("MotherName already Exists {}", motherName.getMotherName());
//                continue;
//            }
//            final ListOfMotherAliasesName listOfMotherAliasesName = this.bulkImportRepositoryWrapper.findOneWithListOfMotherAliasesName(ListOfMotherAliasesName);
//            if (listOfMotherAliasesName != null) {
//                System.out.println("ListOfMotherAliasesName already Exists" + listOfMotherAliasesName.getListOfMotherAliasesName());
//                log.debug("ListOfMotherAliasesName already Exists {}", listOfMotherAliasesName.getListOfMotherAliasesName());
//                continue;
//            }
//            final OtherDetailsAboutMother otherDetailsAboutMother = this.bulkImportRepositoryWrapper.findOneWithOtherDetailsAboutMother(OtherDetailsAboutMother);
//            if (otherDetailsAboutMother != null) {
//                System.out.println("OtherDetailsAboutMother already Exists" + otherDetailsAboutMother.getOtherDetailsAboutMother());
//                log.debug("OtherDetailsAboutMother already Exists {}", otherDetailsAboutMother.getOtherDetailsAboutMother());
//                continue;
//            }
//            final SpouseName spouseName = this.bulkImportRepositoryWrapper.findOneWithSpouseName(SpouseName);
//            if (spouseName != null) {
//                System.out.println("SpouseName already Exists" + spouseName.getSpouseName());
//                log.debug("SpouseName already Exists {}", spouseName.getSpouseName());
//                continue;
//            }
//            final ListOfSpouseAliasesName listOfSpouseAliasesName = this.bulkImportRepositoryWrapper.findOneWithListOfSpouseAliasesName(ListOfSpouseAliasesName);
//            if (listOfSpouseAliasesName != null) {
//                System.out.println("ListOfSpouseAliasesName already Exists" + listOfSpouseAliasesName.getListOfSpouseAliasesName());
//                log.debug("ListOfSpouseAliasesName already Exists {}", listOfSpouseAliasesName.getListOfSpouseAliasesName());
//                continue;
//            }
//            final OtherDetailsAboutSpouse otherDetailsAboutSpouse = this.bulkImportRepositoryWrapper.findOneWithOtherDetailsAboutSpouse(OtherDetailsAboutSpouse);
//            if (otherDetailsAboutSpouse != null) {
//                System.out.println("OtherDetailsAboutSpouse already Exists" + otherDetailsAboutSpouse.getOtherDetailsAboutSpouse());
//                log.debug("OtherDetailsAboutSpouse already Exists {}", otherDetailsAboutSpouse.getOtherDetailsAboutSpouse());
//                continue;
//            }
//            final ChildrenName childrenName = this.bulkImportRepositoryWrapper.findOneWithChildrenName(ChildrenName);
//            if (childrenName != null) {
//                System.out.println("ChildrenName already Exists" + childrenName.getChildrenName());
//                log.debug("ChildrenName already Exists {}", childrenName.getChildrenName());
//                continue;
//            }
//            final ListOfChildrenAliasesName listOfChildrenAliasesName = this.bulkImportRepositoryWrapper.findOneWithListOfChildrenAliasesName(ListOfChildrenAliasesName);
//            if (listOfChildrenAliasesName != null) {
//                System.out.println("ListOfChildrenAliasesName already Exists" + listOfChildrenAliasesName.getListOfChildrenAliasesName());
//                log.debug("ListOfChildrenAliasesName already Exists {}", listOfChildrenAliasesName.getListOfChildrenAliasesName());
//                continue;
//            }
//            final OtherDetailsAboutChildren otherDetailsAboutChildren = this.bulkImportRepositoryWrapper.findOneWithOtherDetailsAboutChildren(OtherDetailsAboutChildren);
//            if (otherDetailsAboutChildren != null) {
//                System.out.println("OtherDetailsAboutChildren already Exists" + otherDetailsAboutChildren.getOtherDetailsAboutChildren());
//                log.debug("OtherDetailsAboutChildren already Exists {}", otherDetailsAboutChildren.getOtherDetailsAboutChildren());
//                continue;
//            }
//            final OtherRelativesName otherRelativesName = this.bulkImportRepositoryWrapper.findOneWithOtherRelativesName(OtherRelativesName);
//            if (otherRelativesName != null) {
//                System.out.println("OtherRelativesName already Exists" + otherRelativesName.getOtherRelativesName());
//                log.debug("OtherRelativesName already Exists {}", otherRelativesName.getOtherRelativesName());
//                continue;
//            }
//            final ListOfOtherRelativesAliasesName listOfOtherRelativesAliasesName = this.bulkImportRepositoryWrapper.findOneWithListOfOtherRelativesAliasesName(ListOfOtherRelativesAliasesName);
//            if (listOfOtherRelativesAliasesName != null) {
//                System.out.println("ListOfOtherRelativesAliasesName already Exists" + listOfOtherRelativesAliasesName.getListOfOtherRelativesAliasesName());
//                log.debug("ListOfOtherRelativesAliasesName already Exists {}", listOfOtherRelativesAliasesName.getListOfOtherRelativesAliasesName());
//                continue;
//            }
//            final OtherDetailsAboutRelatives otherDetailsAboutRelatives = this.bulkImportRepositoryWrapper.findOneWithOtherDetailsAboutRelatives(OtherDetailsAboutRelatives);
//            if (otherDetailsAboutRelatives != null) {
//                System.out.println("OtherDetailsAboutRelatives already Exists" + otherDetailsAboutRelatives.getOtherDetailsAboutRelatives());
//                log.debug("OtherDetailsAboutRelatives already Exists {}", otherDetailsAboutRelatives.getOtherDetailsAboutRelatives());
//                continue;
//            }
//            final CaseDetails caseDetails = this.bulkImportRepositoryWrapper.findOneWithCaseDetails(CaseDetails);
//            if (caseDetails != null) {
//                System.out.println("CaseDetails already Exists" + caseDetails.getCaseDetails());
//                log.debug("CaseDetails already Exists {}", caseDetails.getCaseDetails());
//                continue;
//            }
//            final ListOfSectionOfLaw listOfSectionOfLaw = this.bulkImportRepositoryWrapper.findOneWithListOfSectionOfLaw(ListOfSectionOfLaw);
//            if (listOfSectionOfLaw != null) {
//                System.out.println("ListOfSectionOfLaw already Exists" + listOfSectionOfLaw.getListOfSectionOfLaw());
//                log.debug("ListOfSectionOfLaw already Exists {}", listOfSectionOfLaw.getListOfSectionOfLaw());
//                continue;
//            }
//            final AccusedStatus accusedStatus = this.bulkImportRepositoryWrapper.findOneWithAccusedStatus(AccusedStatus);
//            if (accusedStatus != null) {
//                System.out.println("AccusedStatus already Exists" + accusedStatus.getAccusedStatus());
//                log.debug("AccusedStatus already Exists {}", accusedStatus.getAccusedStatus());
//                continue;
//            }
//            final ListOfLinkedOrganizationName listOfLinkedOrganizationName = this.bulkImportRepositoryWrapper.findOneWithListOfLinkedOrganizationName(ListOfLinkedOrganizationName);
//            if (listOfLinkedOrganizationName != null) {
//                System.out.println("ListOfLinkedOrganizationName already Exists" + listOfLinkedOrganizationName.getListOfLinkedOrganizationName());
//                log.debug("ListOfLinkedOrganizationName already Exists {}", listOfLinkedOrganizationName.getListOfLinkedOrganizationName());
//                continue;
//            }
//            final ListOfLinkedOrganizationNameAliases listOfLinkedOrganizationNameAliases = this.bulkImportRepositoryWrapper.findOneWithListOfLinkedOrganizationNameAliases(ListOfLinkedOrganizationNameAliases);
//            if (listOfLinkedOrganizationNameAliases != null) {
//                System.out.println("ListOfLinkedOrganizationName already Exists" + listOfLinkedOrganizationNameAliases.getListOfLinkedOrganizationNameAliases());
//                log.debug("ListOfLinkedOrganizationName already Exists {}", listOfLinkedOrganizationNameAliases.getListOfLinkedOrganizationNameAliases());
//                continue;
//            }
//            final SummaryOfAllegations summaryOfAllegations = this.bulkImportRepositoryWrapper.findOneWithlistOfLinkedOrganizationNameAliases(listOfLinkedOrganizationNameAliases);
//            if (summaryOfAllegations != null) {
//                System.out.println("ListOfLinkedOrganizationName already Exists" + summaryOfAllegations.getlistOfLinkedOrganizationNameAliases());
//                log.debug("ListOfLinkedOrganizationName already Exists {}", summaryOfAllegations.getlistOfLinkedOrganizationNameAliases());
//                continue;
//            }
//            final PlaceOfDisappearance placeOfDisappearance = this.bulkImportRepositoryWrapper.findOneWithPlaceOfDisappearance(PlaceOfDisappearance);
//            if (placeOfDisappearance != null) {
//                System.out.println("PlaceOfDisappearance already Exists" + placeOfDisappearance.getPlaceOfDisappearance());
//                log.debug("PlaceOfDisappearance already Exists {}", placeOfDisappearance.getPlaceOfDisappearance());
//                continue;
//            }
//            final DateOfDisappearance dateOfDisappearance = this.bulkImportRepositoryWrapper.findOneWithDateOfDisappearance(DateOfDisappearance);
//            if (dateOfDisappearance != null) {
//                System.out.println("DateOfDisappearance already Exists" + dateOfDisappearance.getDateOfDisappearance());
//                log.debug("DateOfDisappearance already Exists {}", dateOfDisappearance.getDateOfDisappearance());
//                continue;
//            }
//            final DistinguishingMarksAndCharacteristics distinguishingMarksAndCharacteristics = this.bulkImportRepositoryWrapper.findOneWithDistinguishingMarksAndCharacteristics(DistinguishingMarksAndCharacteristics);
//            if (distinguishingMarksAndCharacteristics != null) {
//                System.out.println("DistinguishingMarksAndCharacteristics already Exists" + distinguishingMarksAndCharacteristics.getDistinguishingMarksAndCharacteristics());
//                log.debug("DistinguishingMarksAndCharacteristics already Exists {}", distinguishingMarksAndCharacteristics.getDistinguishingMarksAndCharacteristics());
//                continue;
//            }
//            final ExtraInformation extraInformation = this.bulkImportRepositoryWrapper.findOneWithExtraInformation(ExtraInformation);
//            if (extraInformation != null) {
//                System.out.println("ExtraInformation already Exists" + extraInformation.getExtraInformation());
//                log.debug("ExtraInformation already Exists {}", extraInformation.getExtraInformation());
//                continue;
//            }
//            final ListOfLinkedCriminalsIndividuals listOfLinkedCriminalsIndividuals = this.bulkImportRepositoryWrapper.findOneWithListOfLinkedCriminalsIndividuals(ListOfLinkedCriminalsIndividuals);
//            if (listOfLinkedCriminalsIndividuals != null) {
//                System.out.println("ListOfLinkedCriminalsIndividuals already Exists" + listOfLinkedCriminalsIndividuals.getListOfLinkedCriminalsIndividuals());
//                log.debug("ListOfLinkedCriminalsIndividuals already Exists {}", listOfLinkedCriminalsIndividuals.getListOfLinkedCriminalsIndividuals());
//                continue;
//            }

    }
}