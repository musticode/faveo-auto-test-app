package org.testapp.Api.DataProvider.DataGenerator;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class FakeDataGenerator {

    public String fakeMsp(String mspId){
        FakeValuesService faker = new FakeValuesService(new Locale("en-US"), new RandomService());
        return faker.regexify(mspId+"[a-z1-9]{5}");
    }

    public String fakeCompany(){
        FakeValuesService faker = new FakeValuesService(new Locale("en-US"), new RandomService());
        return faker.numerify("#####");
    }

    public String fakeStaffUniqueUser(){
        FakeValuesService faker = new FakeValuesService(new Locale("en-US"), new RandomService());
        return faker.numerify("#####");
    }


}
