//Header for part 1 code

#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
#include <iostream>
#include <fstream>

#define MAX_SENTENCE 5000

using namespace std;

string& trim(string& s);
vector<string>* wordTokenizer(string sentence);
vector<string>* sentenceTokenizer(ifstream& file);
