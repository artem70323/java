package com.gmail.androiddz.domain.interaction.base;

import java.util.ArrayList;

public interface UseCaseJson<InParam, OutParam> {

    ArrayList<OutParam> execute(InParam param);

}

