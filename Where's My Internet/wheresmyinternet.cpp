
#include <bits/stdc++.h>
using namespace std;


vector<vector<int>> AL; 
vector<int> visited;

void dfs(int u) { 
  visited[u] = 1;
  
  for (auto &v : AL[u]){
    if (!visited[v]) dfs(v);
  }
}

int main() {
  ios_base::sync_with_stdio(false); cin.tie(NULL);
  int i;
  int houses, connections; 
  cin >> houses >> connections; 

  AL.assign(houses, vector<int>()); // N rows, indexed [0..N-1]
  for (i = 0; i < connections; i++) { 
    int a, b;
    cin >> a >> b; 
    a--; b--; // from 0 instead of 1
    AL[a].push_back(b); 
    AL[b].push_back(a); 
  }

  // EXPLORE the graph
  visited.assign(houses, 0);
  dfs(0); 

  bool disconnected = false;
  for(i = 0; i < houses; i++){
    if(visited[i] == 0){
      disconnected = true;
      cout << i+1 << endl;
    }
  }
  
  // LAST PART END
  if (!disconnected) cout << "Connected\n";

  return 0;
}