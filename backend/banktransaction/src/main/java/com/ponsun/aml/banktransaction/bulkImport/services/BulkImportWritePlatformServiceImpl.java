package com.ponsun.aml.banktransaction.bulkImport.services;

import com.ponsun.aml.banktransaction.bulkImport.request.AbstractBulkImportBaseRequest;
import com.ponsun.aml.banktransaction.bulkImport.domain.BulkImport;
import com.ponsun.aml.banktransaction.bulkImport.domain.BulkImportRepository;
import com.ponsun.aml.banktransaction.bulkImport.domain.BulkImportRepositoryWrapper;
import com.ponsun.aml.banktransaction.bulkImport.request.CreateBulkImportRequest;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class BulkImportWritePlatformServiceImpl implements BulkImportWritePlatformService {
    final private BulkImportRepository bulkImportRepository;
    final private BulkImportRepositoryWrapper bulkImportRepositoryWrapper;

    @Transactional
    @Override
    public Response saveBulkData(List<Map<String, Object>> rows) {
        long totalRecordSaved = 0L;
        long startTime = System.currentTimeMillis();
        for(Map<String, Object> row: rows) {
//            if(row.get("TransactionDate") == null) {
//                continue;
//            }

            //final String TypeId = ((String) row.get("Type"));
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            final String dateString = (String) row.get("TransactionDate");
            Date date = null;

            try {
                date = dateFormat.parse(dateString);
                System.out.println(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }


            final String SenderId       = ((String) row.get("Sender Customer ID"));
            final String SenderAccount  = ((String) row.get("Sender Account"));
            final String Sender         = ((String) row.get("Sender Name"));
            final String SenderBankName = ((String) row.get("Sender Bank Name"));
            final String Country        = ((String) row.get("Country"));
            final String ReceiverCustomer = ((String) row.get("Receiver Customer ID"));
            final String ReceiverAccount= ((String) row.get("ReceiverAccount"));
            final String Receiver       = ((String) row.get("Receiver"));
            final String ReceiverBankName = ((String) row.get("Receiver Bank Name"));
            final String ReceiverCountry = ((String) row.get("ReceiverCountry"));
            final String Description    = ((String) row.get("Description"));
            final String Deposits       = ((String) row.get("Deposits"));
            final String Withdrawls     = ((String) row.get("Withdrawls"));
            final String Balance        = ((String) row.get("Balance"));

            //Create your BulkImport object and save it to the database.
            //CreateBulkImportRequest createBulkImportRequest = new CreateBulkImportRequest();
            final BulkImport bulkImport = new BulkImport();

//            System.out.println(Country);
//            System.out.println(ReceiverAccount);
//            System.out.println(ReceiverCountry);

            bulkImport.setDate(date);
            bulkImport.setSenderCustomer(SenderId);
            bulkImport.setSenderAccount(SenderAccount);
            bulkImport.setSender(Sender);
            bulkImport.setSenderBankName(SenderBankName);
            bulkImport.setCountry(Country);
            bulkImport.setReceiverCustomer(ReceiverCustomer);
            bulkImport.setReceiverAccount(ReceiverAccount);
            bulkImport.setReceiver(Receiver);
            bulkImport.setReceiverBankName(ReceiverBankName);
            bulkImport.setReceiverCountry(ReceiverCountry);
            bulkImport.setDescription(Description);
            bulkImport.setDeposits(Deposits);
            bulkImport.setWithdrawals(Withdrawls);
            bulkImport.setBalance(Balance);
            bulkImport.onCreate();
            bulkImport.setStatus(Status.ACTIVE);

            //System.out.println(dateString+"   "+SenderId+""+SenderAccount+""+Sender+""+SenderBankName+""+ReceiverCustomer +""+Receiver+""+ReceiverBankName+""+Description+""+Deposits+""+Withdrawls+""+Balance);

            this.bulkImportRepository.saveAndFlush(bulkImport);
            totalRecordSaved = totalRecordSaved + 1;
        }
//    }
        return new Response(totalRecordSaved);
    }
    public enum Day { SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY; }

    public void ss(){
        int numLetters = 0;
        Day day = Day.WEDNESDAY;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalStateException("Invalid day: " + day);
        }
        System.out.println(numLetters);
    }
}



//            final String SourceLink = (String) row.get("B");
//            final String TypeId = (String) row.get("C");
//            final String ListOfPrefix = (String) row.get("D");
//            final String Name = (String) row.get("E");
//            final String Aliases1 = (String) row.get("F");
//            final String Aliases2 = (String) row.get("G");
//            final String Aliases3 = (String) row.get("H");
//            final String Aliases4 = (String) row.get("I");
//            final String Aliases5 = (String) row.get("J");
//            final String Aliases6 = (String) row.get("k");
//            final String Aliases7 = (String) row.get("L");
//            final String Aliases8 = (String) row.get("M");
//            final String Aliases9 = (String) row.get("N");
//            final String Aliases10 = (String) row.get("O");
//            final String Aliases11 = (String) row.get("P");
//            final String Aliases12 = (String) row.get("Q");
//            final String Aliases13 = (String) row.get("R");
//            final String Aliases14 = (String) row.get("S");
//            final String Aliases15 = (String) row.get("T");
//            final String Aliases16 = (String) row.get("U");
//            final String Aliases17 = (String) row.get("V");
//            final String Aliases18 = (String) row.get("W");
//            final String Aliases19 = (String) row.get("X");
//            final String Aliases20 = (String) row.get("Y");
//            final String Aliases21 = (String) row.get("Z");
//            final String Aliases22 = (String) row.get("AA");
//            final String Aliases23 = (String) row.get("AB");
//            final String Aliases24 = (String) row.get("AC");
//            final String Aliases25 = (String) row.get("AD");
            // ((String) entry.getValue());
            //final String TypeId = ((String) row.get("Type")).trim();
//            final String ListOfPrefix = ((String) row.get("List of Prefix")).trim();
//            final String Name = ((String) row.get("Name")).trim();
//            final String Aliases1 = ((String) row.get("Aliases 1")).trim();
//            final String Aliases2 = ((String) row.get("Aliases 2")).trim();
//            final String Aliases3 = ((String) row.get("Aliases 3")).trim();
//            final String Aliases4 = ((String) row.get("Aliases 4")).trim();
//            final String Aliases5 = ((String) row.get("Aliases 5")).trim();
//            final String Aliases6 = ((String) row.get("Aliases 6")).trim();
//            final String Aliases7 = ((String) row.get("Aliases 7")).trim();
//            final String Aliases8 = ((String) row.get("Aliases 8")).trim();
//            final String Aliases9 = ((String) row.get("Aliases 9")).trim();
//            final String Aliases10 = ((String) row.get("Aliases 10")).trim();
//            final String Aliases11 = ((String) row.get("Aliases 11")).trim();
//            final String Aliases12 = ((String) row.get("Aliases 12")).trim();
//            final String Aliases13 = ((String) row.get("Aliases 13")).trim();
//            final String Aliases14 = ((String) row.get("Aliases 14")).trim();
//            final String Aliases15 = ((String) row.get("Aliases 15")).trim();
//            final String Aliases16 = ((String) row.get("Aliases 16")).trim();
//            final String Aliases17 = ((String) row.get("Aliases 17")).trim();
//            final String Aliases18 = ((String) row.get("Aliases 18")).trim();
//            final String Aliases19 = ((String) row.get("Aliases 19")).trim();
//            final String Aliases20 = ((String) row.get("Aliases 20")).trim();
//            final String Aliases21 = ((String) row.get("Aliases 21")).trim();
//            final String Aliases22 = ((String) row.get("Aliases 22")).trim();
//            final String Aliases23 = ((String) row.get("Aliases 23")).trim();
//            final String Aliases24 = ((String) row.get("Aliases 24")).trim();
//            final String Aliases25 = ((String) row.get("Aliases 25")).trim();
//            final String FamilyName = ((String) row.get("Family name")).trim();
//            final String Forename = ((String) row.get("Forename")).trim();
//            final String Gender = ((String) row.get("Gender")).trim();
//            final String ListOfAddress = ((String) row.get("List of Address")).trim();
//            final String State1 = ((String) row.get("State 1")).trim();
//            final String State2 = ((String) row.get("State 2")).trim();
//            final String State3 = ((String) row.get("State 3")).trim();
//            final String State4 = ((String) row.get("State 4")).trim();
//            final String State5 = ((String) row.get("State 5")).trim();
//            final String State6 = ((String) row.get("State 6")).trim();
//            final String DateOfBirth = ((String) row.get("Date of birth / Age As of given")).trim();
//            final String ListOfPlaceOfBirth = ((String) row.get("List of Place of birth")).trim();
//            final String State7 = ((String) row.get("State 7")).trim();
//            final String State8 = ((String) row.get("State 8")).trim();
//            final String State9 = ((String) row.get("State 9")).trim();
//            final String State10 = ((String) row.get("State 10")).trim();
//            final String Nationality = ((String) row.get("Nationality")).trim();
//            final String PassportNumber = ((String) row.get("Passport Number")).trim();
//            final String PANNumber = ((String) row.get("PAN Number")).trim();
//            final String AadharNumber = ((String) row.get("Aadhar Number")).trim();
//            final String DINNumber = ((String) row.get("DIN Number")).trim();
//            final String CINNumber = ((String) row.get("CIN Number")).trim();
//            final String DrivingLicenseNumber = ((String) row.get("Driving License Number")).trim();
//            final String CompanyName = ((String) row.get("Company Name: Working / Owned")).trim();
//            final String Designation = ((String) row.get("Designation: Working / Owned")).trim();
//            final String Place = ((String) row.get("Place: Working / Owned")).trim();
//            final String OtherDetailsAboutCompany = ((String) row.get("Other Details About Company")).trim();
//            final String FatherName = ((String) row.get("Father Name")).trim();
//            final String ListOfFatherAliasesName = ((String) row.get("List of Father Aliases Name")).trim();
//            final String OtherDetailsAboutFather = ((String) row.get("Other Details About Father")).trim();
//            final String MotherName = ((String) row.get("Mother Name")).trim();
//            final String ListOfMotherAliasesName = ((String) row.get("List of Mother Aliases Name")).trim();
//            final String OtherDetailsAboutMother = ((String) row.get("Other Details About Mother")).trim();
//            final String SpouseName = ((String) row.get("Spouse Name")).trim();
//            final String ListOfSpouseAliasesName = ((String) row.get("List of Spouse Aliases Name")).trim();
//            final String OtherDetailsAboutSpouse = ((String) row.get("Other Details About Spouse")).trim();
//            final String ChildrenName = ((String) row.get("Children Name")).trim();
//            final String ListOfChildrenAliasesName = ((String) row.get("List of Children Aliases Name")).trim();
//            final String OtherDetailsAboutChildren = ((String) row.get("Other Details About Children")).trim();
//            final String OtherRelativesName = ((String) row.get("Children Name")).trim();
//            final String ListOfOtherRelativesAliasesName = ((String) row.get("List of Other Relatives Aliases Name")).trim();
//            final String OtherDetailsAboutRelatives = ((String) row.get("Other Details About Relatives")).trim();
//            final String CaseDetails = ((String) row.get("Case Details")).trim();
//            final String ListOfSectionOfLaw = ((String) row.get("List of Section of Law:")).trim();
//            final String AccusedStatus = ((String) row.get("Accused Status")).trim();
//            final String ListOfLinkedOrganizationName = ((String) row.get("List of Linked Organization Name")).trim();
//            final String ListOfLinkedOrganizationNameAliases = ((String) row.get("List of Linked Organization Name Aliases")).trim();
//            final String SummaryOfAllegations = ((String) row.get("Summary of Allegations:")).trim();
//            final String PlaceOfDisappearance = ((String) row.get("Place of disappearance")).trim();
//            final String DateOfDisappearance = ((String) row.get("Date of disappearance")).trim();
//            final String DistinguishingMarksAndCharacteristics = ((String) row.get("Distinguishing marks and characteristics")).trim();
//            final String ExtraInformation = ((String) row.get("Extra Information:")).trim();
//            final String ListOfLinkedCriminalsIndividuals = ((String) row.get("List of Linked Criminals / Individuals")).trim();


//            CreateBulkImportRequest createBulkImportRequest = new CreateBulkImportRequest();
//            createBulkImportRequest.setSourceLink(SourceLink);
//            createBulkImportRequest.setTypeId(TypeId);
//            createBulkImportRequest.setName(Name);
//            createBulkImportRequest.setListOfPrefix(ListOfPrefix);
//            createBulkImportRequest.setAliases1(Aliases1);
//            createBulkImportRequest.setAliases2(Aliases2);
//            createBulkImportRequest.setAliases3(Aliases3);
//            createBulkImportRequest.setAliases4(Aliases4);
//            createBulkImportRequest.setAliases5(Aliases5);
//            createBulkImportRequest.setAliases6(Aliases6);
//            createBulkImportRequest.setAliases7(Aliases7);
//            createBulkImportRequest.setAliases8(Aliases8);
//            createBulkImportRequest.setAliases9(Aliases9);
//            createBulkImportRequest.setAliases10(Aliases10);
//            createBulkImportRequest.setAliases11(Aliases11);
//            createBulkImportRequest.setAliases12(Aliases12);
//            createBulkImportRequest.setAliases13(Aliases13);
//            createBulkImportRequest.setAliases14(Aliases14);
//            createBulkImportRequest.setAliases15(Aliases15);
//            createBulkImportRequest.setAliases16(Aliases16);
//            createBulkImportRequest.setAliases17(Aliases17);
//            createBulkImportRequest.setAliases18(Aliases18);
//            createBulkImportRequest.setAliases19(Aliases19);
//            createBulkImportRequest.setAliases20(Aliases20);
//            createBulkImportRequest.setAliases21(Aliases21);
//            createBulkImportRequest.setAliases22(Aliases22);
//            createBulkImportRequest.setAliases23(Aliases23);
//            createBulkImportRequest.setAliases24(Aliases24);
//            createBulkImportRequest.setAliases25(Aliases25);
//            createBulkImportRequest.setFamilyName(FamilyName);
//            createBulkImportRequest.setForename(Forename);
//            createBulkImportRequest.setGender(Gender);
//            createBulkImportRequest.setListOfAddress(ListOfAddress);
//            createBulkImportRequest.setStateid1(State1);
//            createBulkImportRequest.setStateid2(State2);
//            createBulkImportRequest.setStateid3(State3);
//            createBulkImportRequest.setStateid4(State4);
//            createBulkImportRequest.setStateid5(State5);
//            createBulkImportRequest.setStateid6(State6);
//            createBulkImportRequest.setDateOfBirth(DateOfBirth);
//            createBulkImportRequest.setListofPlaceofBirth(ListOfPlaceOfBirth);
//            createBulkImportRequest.setStateid7(State7);
//            createBulkImportRequest.setStateid8(State8);
//            createBulkImportRequest.setStateid9(State9);
//            createBulkImportRequest.setStateid10(State10);
//            createBulkImportRequest.setNationality(Nationality);
//            createBulkImportRequest.setPassportNumber(PassportNumber);
//            createBulkImportRequest.setPanNumber(PANNumber);
//            createBulkImportRequest.setAadharNumber(AadharNumber);
//            createBulkImportRequest.setDinNumber(DINNumber);
//            createBulkImportRequest.setCinNumber(CINNumber);
//            createBulkImportRequest.setDrivinglicenseNumber(DrivingLicenseNumber);
//            createBulkImportRequest.setCompanyName(CompanyName);
//            createBulkImportRequest.setDesignation(Designation);
//            createBulkImportRequest.setPlace(Place);
//            createBulkImportRequest.setOtherDetailsAboutCompany(OtherDetailsAboutCompany);
//            createBulkImportRequest.setFatherName(FatherName);
//            createBulkImportRequest.setListofFatherAliasesName(ListOfFatherAliasesName);
//            createBulkImportRequest.setOtherDetailsAboutFather(OtherDetailsAboutFather);
//            createBulkImportRequest.setMotherName(MotherName);
//            createBulkImportRequest.setListofMotherAliasesName(ListOfMotherAliasesName);
//            createBulkImportRequest.setOtherDetailsAboutMother(OtherDetailsAboutMother);
//            createBulkImportRequest.setSpouseName(SpouseName);
//            createBulkImportRequest.setListofSpouseAliasesName(ListOfSpouseAliasesName);
//            createBulkImportRequest.setOtherDetailsAboutSpouse(OtherDetailsAboutSpouse);
//            createBulkImportRequest.setChildrenName(ChildrenName);
//            createBulkImportRequest.setListofChildrenAliasesName(ListOfChildrenAliasesName);
//            createBulkImportRequest.setOtherDetailsAboutChildren(OtherDetailsAboutChildren);
//            createBulkImportRequest.setOtherRelativesName(OtherRelativesName);
//            createBulkImportRequest.setListofOtherRelativesAliasesName(ListOfOtherRelativesAliasesName);
//            createBulkImportRequest.setOtherDetailsAboutRelatives(OtherDetailsAboutRelatives);
//            createBulkImportRequest.setCaseDetails(CaseDetails);
//            createBulkImportRequest.setListofSectionofLaw(ListOfSectionOfLaw);
//            createBulkImportRequest.setAccusedStatus(AccusedStatus);
//            createBulkImportRequest.setListofLinkedOrganizationName(ListOfLinkedOrganizationName);
//            createBulkImportRequest.setListofLinkedOrganizationNameAliases(ListOfLinkedOrganizationNameAliases);
//            createBulkImportRequest.setSummaryOfAllegation(SummaryOfAllegations);
//            createBulkImportRequest.setPlaceofDisappearance(PlaceOfDisappearance);
//            createBulkImportRequest.setDateOfDisappearance(DateOfDisappearance);
//            createBulkImportRequest.setDistingushingMarksAndCharacteristics(DistinguishingMarksAndCharacteristics);
//            createBulkImportRequest.setExtraInformation(ExtraInformation);
//            createBulkImportRequest.setLisofLinkedCriminalIndividuals(ListOfLinkedCriminalsIndividuals);

//            BulkImport bulkImport = BulkImport.create(createBulkImportRequest);
//
//            bulkImportRepository.saveAndFlush(bulkImport);
//            totalRecordSaved = totalRecordSaved + 1;
//        }
//    //}
//
//        long endTime = System.currentTimeMillis();
//        System.out.println("Total milliseconds taken: " + (endTime - startTime));
//        return new Response(totalRecordSaved);
//    }
//}




