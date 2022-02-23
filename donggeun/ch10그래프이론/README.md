# 최단 경로

# 다양한 그래프 알고리즘

## 이미 배운 내용을 훑어보자
- 5장의 `BFS/BFS`와 9장의 `최단 경로`에서 다룬 내용은 모두 그래프 알고리즘의 한 유형으로 볼 수 있다.
- 이번 장에서 다룰 내용도 모두 앞서 배운 내용에 기반한다.
  - `크루스칼 알고리즘 (Kruskal Algorithms)`은 그리디 알고리즘으로 분류됨
  - `위상 정렬 알고리즘 (Topology Algorithms)`은 앞서 배운 `큐`, `스택` 자료구조를 활용
- 그래프란?
  - `노드`와 노드 사이에 연결된 `간선`의 정보를 가지고 있는 자료구조
  - 서로 다른 개체(객체)가 연결 되었다는 정보가 있을 때 사용하기 좋다.
- 트리란?
  - 그래프의 한 종류로, 방향 그래프이며 비순환이라는 특징을 갖고 있다.
- 그래프의 구현 방법은 크게 2차원 배열을 사용하는 `인접 행렬`과 리스트를 사용하는 `인접 리스트` 방식이 있다.
- 인접 행렬의 경우 `O(V^2)`의 메모리 공간이, 리스트의 경우 `O(E)`만큼의 메모리 공간이 필요하다.
- 탐색의 경우 인접 행렬은 `O(1)`, 리스트의 경우 `O(V)`의 시간이 소요된다.

## 서로소 집합
- `Disjoint Sets`: 공통 원소가 없는 두 집합
  - {1, 2} 와 {3, 4}
- 서로소 집합의 연산에는 2가지가 있다.
  - `union`: 2개의 원소가 포함된 집합을 하나의 집합으로 합치는 연산
  - `find`: 특정한 원소가 속한 집합이 어떤 집합인지 알려줌

  ### 서로소 집합 자료구조
  - 트리 자료구조를 이용하여 표현
    1. `union`연산을 확인하여 서로 연결된 두 노드 A, B를 확인
       1. A와 B의 루트 노드를 각각 찾고
       2. A의 루트노드를 B 루트노드의 부모로 설정
    2. 모든 `union`연산을 처리할 때까지 1 반복

  ```python
  # 특정 원소가 속한 집합을 찾기
  def find_parent(parent, x):
    # 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x
  
  # 두 원소가 속한 집합을 합치기
  def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b
  ```
  - 단순하게 위와 같이 알고리즘을 구성할 경우, 노드의 루트를 찾기 위해서 `O(VM)`의 시간이 필요해 비효율적이다.
  - `경로 압축 (Path Compression)` 기법을 통해 이를 개선시킬 수 있다.
  ```python
  def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]
  ```
  
## 신장 트리
- `Spanning Tree`: 하나의 그래프가 있을 때, 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프

  ### 크루스칼 알고리즘
  - 신장 트리 중에서 최소 비용으로 만들 수 있는 신장 트리를 찾는 알고리즘: `최소 신장 트리 알고리즘`
  - MST 알고리즘의 대표적인 알고리즘이 `크루스칼 알고리즘`이다.
    1. 간선 데이터를 비용에 따라 오름차순 정렬
    2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인
       1. 사이클 O -> MST에 포함 X
       2. 사이클 X -> MST에 포함
    3. 모든 간선에 대하여 2번의 과정을 반복
  ```python
  for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost
  ```
  
  ### 크루스칼 알고리즘의 시간 복잡도
  - 간선의 개수가 E개일 때 `O(ElogE)`
  - 정렬하는데 가장 오랜 시간이 걸리기 때문이다.

## 위상 정렬
- `Topology Sort`: 순서가 정해져 있는 일련의 작업을 차례로 수행
  - 방향 그래프의 모든 노드를 '방향성에 거스르지 않도록 순서대로 나열'
- 현실 세계에서 대표적인 예시는 '선수과목을 고려한 학습 순서 설정'을 예로 들 수 있다.
- 알고리즘
  1. 진입차수가 0인 노드를 큐에 넣는다.
  2. 큐가 빌 때까지 다음의 과정을 반복한다.
     1. 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거한다.
     2. 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.

```python

for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    indegree[b] += 1
    
def topology_sort():
    result = []
    q = deque()
    
    for i in range(1, v + 1):
        if indegree[i] == 0:
            q.append(i)
    
    while q:
        now = q.popleft()
        result.append(now)
        
        for i in graph[now]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)
```

  ### 위상 정렬의 시간 복잡도
  - `O(V+E)`
  - 모든 노드와 간선을 확인하기 때문!

# 문제

- 페이지: [이것이 취업을 위한 코딩 테스트다] 수록 페이지
- BJ: BAEKJOON 문제


|이름|페이지|코드|해결|
|:---:|:---:|:---:|:---:|
|팀 결성|298|[🚀](./팀결성.java)|✅|
|[도시 분할 계획](https://www.acmicpc.net/problem/1647)|300|[🚀](./도시분할계획.java)|✅|
|커리큘럼|303|[🚀](./커리큘럼.java)|✅|
|여행 계획|393|[🚀](./여행계획.java)|✅|
|탑승구|395|[🚀](./탑승구.java)|✅ 서로소로 풀어보기|
|어두운 길|397|[🚀](./어두운길.java)|✅|
|[행성 터널](https://www.acmicpc.net/problem/2887)|398|[🚀](./행성터널.java)|메모리 초과|
|[최종 순위](https://www.acmicpc.net/problem/3665)|399|[🚀](./최종순위.java)|✅|
