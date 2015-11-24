/*
 * Copyright 2015
 *  http://wazza.co.ke
 */

package smarthomes.domain.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *Generate random 4 digit code  for image directory name.
 * @author kelli
 */
public class CodeGenerator {
    
    private final List<Integer> numbers = new ArrayList();
    private int x=0;
    
    public  CodeGenerator(){
        for (int i = 1000; i < 10000; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
    }
    
    public int getNextInt(){
        return numbers.get(x++);
    }

}
