package com.accolite.hiring.demo.service;

import com.accolite.hiring.demo.entity.Slot;
import com.accolite.hiring.demo.util.GoogleSheetUtil;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GoogleSheetService {

    @Autowired
    GoogleSheetUtil googleSheetUtil;

    @Value("${SPREAD_SHEET_ID}")
    private String SHEET_ID;

    public List<Slot> getAllSlots() {
        List<Slot> slots = new ArrayList<>();
        try {
            Sheets sheets = googleSheetUtil.getSheetsObject();
            sheets.spreadsheets().values()
                    .get(SHEET_ID, "Master!A2:E")
                    .execute();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return slots;
    }

    public Boolean putSlot() {
        try {
            Sheets sheets = googleSheetUtil.getSheetsObject();
            List<List<Object>> lists = Arrays.asList(Arrays.asList("Poobesh 1", "Poobesh 2"));
            ValueRange body = new ValueRange()
                    .setValues(lists);
            String valueInputOption = "USER_ENTERED";
            UpdateValuesResponse result = sheets.spreadsheets().values().update(SHEET_ID, "Master!A1:b9", body)
                    .setValueInputOption(valueInputOption)
                    .execute();
            System.out.println("Response : \n" + result);
            return true;
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
