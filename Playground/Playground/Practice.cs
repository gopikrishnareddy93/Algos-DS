using System;
using System.Collections.Generic;
using System.Text;

namespace Playground
{
    public static class Practice
    {
        public static void Run()
        {
            //Console.WriteLine(solution("aaa"));
            Console.WriteLine(solution("ccaaffddecee"));

        }

        static int solution(string S)
        {
            int max = 0;

            int cc = 0;
            Char cch, pch;

            int ci = 1;

            while (ci < S.Length - 1)
            {
                cch = S[ci];
                pch = S[ci - 1];
                

            }


            return 0;

        }

        static int solution2(string S)
        {
            // write your code in C# 6.0 with .NET 4.5 (Mono)
            Dictionary<char, int> characterCounts = new Dictionary<char, int>();

            foreach (var ch in S)
            {
                int value = characterCounts.ContainsKey(ch) ? characterCounts[ch] : 0;
                characterCounts[ch] = value + 1;
            }

            int result = 0;
            Dictionary<int, bool> counts = new Dictionary<int, bool>();



            foreach (var cnt in characterCounts.Values)
            {
                if (!counts.ContainsKey(cnt))
                {
                    counts.Add(cnt, true);
                    continue;
                }

                int temp = cnt - 1;
                result++;

                while (counts.ContainsKey(temp))
                {
                    temp--;
                    result++;
                }

                if (temp > 0)
                {
                    counts.Add(temp, true);
                }
            }
            

            return result;
        }
    


    static string solution1(string S)
        {
            string res = "";

            //move from start till end
            for (int i = 0; i < S.Length - 1 ; i++)
            {
                // if current character is alphabetically larger then return the string without current character
                if (S[i] > S[i + 1])
                {
                    for (int j = 0; j < S.Length; j++)
                    {
                        if (i != j)
                        {
                            res += S[j];
                        }
                    }

                    return res;
                }
            }

            // if we didn't find any character whose value is less than next character then remove last character
            res = S.Substring(0, S.Length - 1);
            return res;

        }
    }
}
