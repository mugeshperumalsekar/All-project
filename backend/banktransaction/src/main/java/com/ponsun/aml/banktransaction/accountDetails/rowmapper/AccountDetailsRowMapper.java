package com.ponsun.aml.banktransaction.accountDetails.rowmapper;


import com.ponsun.aml.banktransaction.accountDetails.data.AccountDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class AccountDetailsRowMapper implements RowMapper<AccountDetailsData> {
    private final String schema;
    public AccountDetailsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM bank_sender_receiver_details bank ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("bank.id as id, ");
        builder.append("bank.date as date, ");
        builder.append("bank.senderCustomer as senderCustomer, ");
        builder.append("bank.senderAccount as senderAccount ,");
        builder.append("bank.sender as sender, ");
        builder.append("bank.senderBankName as senderBankName, ");
        builder.append("bank.receiverCustomer as receiverCustomer, ");
        builder.append("bank.receiverAccount as receiverAccount, ");
        builder.append("bank.receiver as receiver, ");
        builder.append("bank.receiverBankName as receiverBankName, ");
        builder.append("bank.description as description, ");
        builder.append("bank.deposits as deposits, ");
        builder.append("bank.withdrawals as withdrawals, ");
        builder.append("bank.balance as balance ");

        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public AccountDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Date    date = rs.getDate("date");
        final String  senderCustomer = rs.getString("senderCustomer");
        final String  senderAccount = rs.getString("senderAccount");
        final String  sender = rs.getString("sender");
        final String  senderBankName = rs.getString("senderBankName");
        final String  receiverCustomer = rs.getString("receiverCustomer");
        final String  receiverAccount = rs.getString("receiverAccount");
        final String  receiver = rs.getString("receiver");
        final String  receiverBankName = rs.getString("receiverBankName");
        final String  description = rs.getString("description");
        final String  deposits = rs.getString("deposits");
        final String  withdrawals = rs.getString("withdrawals");
        final String  balance = rs.getString("balance");
        return new AccountDetailsData(id,date,senderCustomer,senderAccount,sender,senderBankName,receiverCustomer,receiverAccount,receiver,receiverBankName,description,deposits,withdrawals,balance);
    }
}
