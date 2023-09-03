package com.curso.android.app.projectofinalticmas.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.curso.android.app.projectofinalticmas.model.TextComparisonModel;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<Boolean> comparisonResult = new MutableLiveData<>();
    private final TextComparisonModel textComparisonModel = new TextComparisonModel();

    public MutableLiveData<Boolean> getComparisonResult() {
        return comparisonResult;
    }

    public void compareTexts(String text1, String text2) {
        boolean areEqual = textComparisonModel.areTextsEqual(text1, text2);
        comparisonResult.postValue(areEqual);
    }
}

