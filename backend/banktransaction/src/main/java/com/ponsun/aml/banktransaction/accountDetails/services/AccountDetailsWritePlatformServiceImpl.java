package com.ponsun.aml.banktransaction.accountDetails.services;

import com.ponsun.aml.banktransaction.accountDetails.data.AccountDetailsDataValidator;
import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.accountDetails.domain.*;
import com.ponsun.aml.banktransaction.accountDetails.request.CreateAccountDetailsRequest;
import com.ponsun.aml.banktransaction.accountDetails.request.UpdateAccountDetailsRequest;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountDetailsWritePlatformServiceImpl implements AccountDetailsWritePlatformService{

    private final AccountDetailsRepository accountDetailsRepository;
    //private final AlertGenerationRepository alertGenerationRepository;
    private final AccountDetailsRepositoryWrapper accountDetailsRepositoryWrapper;
    private final AccountDetailsDataValidator accountDetailsDataValidator;

    @Override
    @Transactional
    public Response createAccountDetails(CreateAccountDetailsRequest createAccountDetailsRequest) throws AppicationException {
        try{
            this.accountDetailsDataValidator.validateSaveAccountDetailsData(createAccountDetailsRequest);
            final AccountDetails accountDetails = AccountDetails.create(createAccountDetailsRequest);
            this.accountDetailsRepository.saveAndFlush(accountDetails);
            return Response.of(accountDetails.getId());
        }catch (DataIntegrityViolationException e){
            throw new AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateAccountDetails(Integer id, UpdateAccountDetailsRequest updateAccountDetailsRequest) throws AppicationException {
        try {
            this.accountDetailsDataValidator.validateUpdateAccountDetailsData(updateAccountDetailsRequest);
            final AccountDetails accountDetails = this.accountDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            accountDetails.update(updateAccountDetailsRequest);
            this.accountDetailsRepository.saveAndFlush(accountDetails);
            return Response.of(accountDetails.getId());
        } catch (DataIntegrityViolationException e) {
            throw new AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockAccountDetails(Integer id) throws AppicationException {
        try{
            final AccountDetails accountDetails = this.accountDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            accountDetails.setStatus(Status.DELETE);
            accountDetails.setUpdatedAt(LocalDateTime.now());
            this.accountDetailsRepository.saveAndFlush(accountDetails);
            return Response.of(id);
        }catch (DataIntegrityViolationException e){
            throw new AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockAccountDetails(Integer id) throws AppicationException {
        try {
            final AccountDetails accountDetails = this.accountDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            accountDetails.setStatus(Status.ACTIVE);
            accountDetails.setUpdatedAt(LocalDateTime.now());
            this.accountDetailsRepository.saveAndFlush(accountDetails);
            return Response.of(id);
        } catch (DataIntegrityViolationException e){
            throw new AppicationException(e.getMessage());
        }
    }

//    @Override
//    public Response AlertGeneration() {
//
////        AlertGeneration alertGeneration = new AlertGeneration();
////        StoredProcedureQuery query = this.alertGenerationRepository.saveAndFlush(alertGeneration);
////        //StoredProcedureQuery query = this.alertGenerationRepository.em.createNamedStoredProcedureQuery("calculate");
////        query.setParameter("x", 1.23d);
////        query.setParameter("y", 4.56d);
////        query.execute();
//
//
//        //this.alertGenerationRepository.save(alertGeneration);
//
//
//
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
//        EntityManager em = emf.createEntityManager();
//
//        // Call stored procedure
//        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("SP_AlertGeneration");
//        query.execute();
//        //List<Employee> employees = query.getResultList();
//
//        // Display results
////        for (Employee employee : employees) {
////            System.out.println("Employee: " + employee.getName() + " Department: " + employee.getDepartment());
////        }
////
////        em.close();
////        emf.close();
//
//
//
//        return null;
//    }
}
