 public static void lps(String x)
    {
      int len=x.length();
      if(len==0)
       return;
      int maxlength=1;                                                     //stores max length of palindrome
      int start=0;                                                         //starting index of palindrome
      boolean dp[][]=new boolean[len][len];   
      for(int i=0;i<len;i++)
      {
        dp[i][i]=true;                                                    //Every single character is palindrome

      }
     for(int i=0;i<len-1;i++)
     {
        if(x.charAt(i)==x.charAt(i+1))
        {
            dp[i][i + 1] = true;                                          //two consecutive similar characters are                  start=i;                                                      //palindrome i.e bb, aa etc
            maxlength=2;

        }
     }
      for(int i=3;i<=len;i++)                                             //"i" is length of palindrome
          for(int j=0;j<len-i+1;j++)                                      //"j" is the starting index
          {
            int k=j+i-1;                                                  //"k" is the index where palindrome ends
            if(x.charAt(j)==x.charAt(k) && dp[j+1][k-1]==true)
            {
              dp[j][k]=true;
              if(maxlength<i)
              {
               start=j;
               maxlength=i;
              }

            }
          }
      System.out.println("Length of LCS is "+maxlength+" and it starts at "+start);

    }
    
 /*
  e.g consider string "camdmac"
  The table for the above string would be
  
        true        false        false        false        false        false        true
        false        true        false        false        false        true        false
        false        false        true        false        true        false        false
        false        false        false        true        false        false        false
        false        false        false        false        true        false        false
        false        false        false        false        false        true        false
        false        false        false        false        false        false        true
        
 Initially all the diagonals will be true i.e [0][0].....[6][6]. Then second for loop will look for palindrome of length  2. We do not have any palindrome of length 2. Then algorithm would go to line 23 and it will find palindrome of max length.
 
 Reference:http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 */
