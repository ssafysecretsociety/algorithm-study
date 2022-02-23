# 최단 경로

# 가장 빠른 길 찾기

## 가장 빠르게 도달하는 방법
- `최단 경로 (Shortest Path)`: 말 그대로 가장 짧은 경로를 찾는 알고리즘
  - 다양한 유형의 알고리즘이 이미 존재하고, 상황에 맞는 효율적인 알고리즘이 이미 정립되어 있다.
- 각 지점은 그래프에서 `노드`로 표현되고, 지점간 연결된 도로는 그래프에서 `간선`으로 표현된다.
- 주로 사용되는 알고리즘
  - `다익스트라`
  - `플로이드 워셜`
  - `벨만 포드`
- 최단 경로 알고리즘의 특징은, 앞서 배운 `그리디 알고리즘`과 `다이나믹 프로그래밍 알고리즘`이 그대로 적용된다는 특징이 있다.

## 다익스트라 최단 경로 알고리즘
- 그래프에서 여러 개의 노드가 있을 때, 특정한 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 구해주는 알고리즘
  - `음의 간선`이 없을 때 정상적으로 동작
  - 이러한 특성으로, 현실 GPS SW의 기본 알고리즘으로 채택되곤 함
- 기본적으로 그리디 알고리즘으로 분류
  1. 출발 노드를 설정
  2. 최단 거리 테이블을 초기화
  3. 방문하지 않은 노드 중에서 최단거리가 가장 짧은 노드 선택
  4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블 갱신
  5. 3~4번 과정 반복
- 항상 1차원 리스트에 `각 노드에 대한 현재까지의 최단 거리` 정보를 저장해 갱신하는 특징이 있다.
- 한 단계당 하나의 노드에 대한 최단 거리를 확실히 찾는 것!

  ### 방법 1. 간단한 알고리즘
  - `O(V^2)`의 시간 복잡도
  ```python
  start / graph / visited / distance = [INF] * (n + 1)
  
  def get_smallest_node():
    min_value = INF
    index = 0
    for i in range(1, n+1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            index = i
    return index
  
  def dijkstra(start):
    # 시작 노드에 대해서 초기화
    distance[start] = 0
    visited[start] = True
    for j in graph[start]:
        distance[j[0]] = j[1]
    
    # 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
    for i in range(n-1):
        now = get_smallest_node()
        visited[now] = True
        # 현재 노드와 연결된 다른 노드를 확인
        for j in graph[now]:
            cost = distance[now] + j[1]
            # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost <distnace[j[0]]:
                distance[j[0]] = cost
  
  ```
  
  ### 방법 2. 개선된 알고리즘
  - 최악의 경우에도 시간 복잡도 `O(ElogV)` 보장
  - 힙 자료구조를 사용
    - 현재 가장 가까운 노드를 저장하기 위한 목적

  ```python
  def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
  ```

## 플로이드 워셜 알고리즘
- `다익스트라`는 한 지점에서 다른 특정 지점까지의 거리를 구할 때 사용하는 알고리즘
- `플로이드 워셜`은 모든 지점에서 다른 모든 지점까지 구해야 하는 경우 사용한다.
- 다익스트라와 다르게 최단 거리를 갖는 노드를 찾을 필요가 없다
- N번의 단계를 수행, 각 단계는 `O(N^2)`으로 총 시간 복잡도는 `O(N^3)`이다.
- 다익스트라와 다르게 2차원 리스트에 최단 거리 정보를 저장한다.
```python
graph = [[INF] * (n + 1) for _ in range(n + 1)]

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
```

# 문제

- 페이지: [이것이 취업을 위한 코딩 테스트다] 수록 페이지
- BJ: BAEKJOON 문제


|이름|페이지|코드|해결|
|:---:|:---:|:---:|:---:|
|미래 도시|259|[🚀](./미래도시.java)|✅|
|전보|262|[🚀](./전보.java)|✅|
|[플로이드](https://www.acmicpc.net/problem/11404)|385|[🚀](./플로이드.java)|✅|
|정확한 순위|386|[🚀](./정확한순위.java)|✅|
|화성 탐사|388|[🚀](./화성탐사.java)|✅|
|숨바꼭질|390|[🚀](./숨바꼭질.java)|✅|
