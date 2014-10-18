package com.dragonq.dragonq;

import java.io.IOException;
import java.util.List;

/**
 * Created by Андрей on 18.10.2014.
 */
public interface Gettarable {
    List<Question> getQuestion() throws IOException;
}
