# DFS / BFS

- 그래프를 탐색하기 위한 대표적인 두 가지 알고리즘

# 꼭 필요한 자료구조 기초

- `탐색`: 많은 양의 데이터 중에서 원하는 데이터를 찾는 과정
    - 그래프, 트리 등의 자료구조 안에서 탐색하는 문제를 자주 다룬다.
    - 대표적인 탐색 알고리즘으로 `DFS`, `BFS`가 있다.


- `자료구조`: 데이터를 표현하고 관리하고 처리하기 위한 구조
    - 대표적인 자료구조에는 스택, 큐가 있다.

## 스택 / 큐

- `스택(Stack)`: 박스 쌓기 - 후입선출 (Last in First Out, LIFO)
- `큐(Queue)`: 대기 줄 - 선입선출 (First in First Out, FIFO)
- 자바에서는 `java.util.Queue`, `java.util.Stack`으로 사용 가능하다.

## 재귀 함수

- DFS / BFS 구현을 위해 이해가 필요하다.
- `재귀 함수(Recursive Function)`: 자기 자신을 다시 호출하는 함수
  ```python
  def recursive_function():
    print("재귀 함수를 호출합니다.")
    recursive_function()
  
  recursive_function()
  ```

  ### 재귀 함수의 종료 조건
    - 위와 같은 코드는 무한히 반복하여 호출 제한을 벗어나게 된다.
    - 따라서 적절한 종료 조건을 추가해, 함수가 무한히 반복하지 않도록 방지해야한다.

  ### 재귀 함수의 장점
    - 더 간결한 코드를 작성할 수 있다.

# 탐색 알고리즘 DFS / BFS

## DFS

- `Depth-First-Search`: 깊이 우선 탐색
- 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘

  ### 그래프
    - `노드`와 노드를 이어주는 `간선`으로 구성됨
    - 프로그래밍에서 그래프는 크게 2가지 방식으로 표현된다.
        1. 인접 행렬: 2차원 배열로 그래프간의 연결 관계를 표현
           ```
           graph = [
             [0, 7, 5],
             [7, 0, INF],
             [5, INF, 0]
           ]
           ```

        2. 인접 리스트: 리스트로 그래프의 연결 관계를 표현
            ```
           graph = [][]
           
           graph[0].append((1,7))
           graph[0].append((2,5))
           
           graph[1].append((0,7))
           
           graph[2].append((0,5))
           ```
    - 메모리 측면에서는 인접 리스트가 유리, 속도 측면에서는 인접 행렬이 유리


- `DFS`는 스택 자료구조를 이용한다.
    1. 탐색 시작 노드를 스택에 삽입하고 방문처리
    2. 스택의 최상단 노드에 방문하지 않은 인접노드가 있다면, 그 인접 노드를 스택에 넣고 방문처리 방문하지 않은 인접 노드가 없다면 스택에서 최상단 노드를 꺼낸다.
    3. 2번 과정을 더 이상 수행할 수 없을 때 까지 반복
- `DFS`는 스택 자료구조에 기초한다는 점에서 구현이 간단하다
- `O(N)`의 시간이 소요된다.

```python
# DFS 예제
def dfs(graph, v, visited):
    # 현재 노드를 방문 처리
    visited[v] = True
    print(v, end=' ')
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

# 각 노드가 연결된 정보를 리스트 자료형으로 표현
graph = [
    [],
    [2, 3, 8],
    ...
    [1, 7]
    ]

# 각 노드가 방문된 정보를 리스트 자료형으로 표현
visited = [False] * 9

# 정의된 DFS 함수 호출
dfs(graph, 1, visited)
```

## BFS

- `Breadth First Search`: 너비 우선 탐색
- 가까운 노드부터 탐색하는 알고리즘 (cf: `DFS`는 최대한 멀리 있는 노드를 우선으로 탐색)
- 선입선출 방식의 `큐` 사용
- 알고리즘
    1. 탐색 시작 노드를 큐에 삽입하고 방문 처리
    2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입, 방문처리
    3. 2번 과정을 더 이상 수행할 수 없을 때까지 반복

- `큐` 자료구조에 기초한다는 점에서 구현이 간편
- `O(N)`의 시간 소요
- 일반적인 경우 실제 수행 시간은 `DFS`보다 좋은 편

```
from collections import deque

# BFS 메서드 정의
def bfs(graph, start, visited):
    # 큐 구현을 위해 deque 라이브러리 사용
    queue = deque([start])
    # 현재 노드를 방문 처리
    visited[start] = True
    # 큐가 빌 때까지 반복
    while queue:
        # 큐에서 하나의 원소를 뽑아 출력
        v = queue.popleft()
        print(v, end=' ')
        # 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

# 각 노드가 연결된 정보를 리스트 자료형으로 표현
graph = [
    [],
    [2, 3, 8],
    ...
    [1, 7]
    ]

# 각 노드가 방문된 정보를 리스트 자료형으로 표현
visited = [False] * 9

# 정의된 BFS 함수 호출
bfs(graph, 1, visited)
```

## 정리

| |DFS|BFS|
|:---:|:---:|:---:|
|동작 원리|스택|큐|
|구현 방법|재귀 함수 이용|큐 자료구조 이용|

# 문제

- 페이지: [이것이 취업을 위한 코딩 테스트다] 수록 페이지
- BJ: BAEKJOON 문제

|이름|페이지|코드|해결|
|:---:|:---:|:---:|:---:|
|음료수 얼려 먹기|149|[🚀](./음료수얼려먹기.java)|✅|
|미로 탈출|152|[🚀](./미로탈출.java)|✅|
|[특정 거리의 도시 찾기](https://www.acmicpc.net/problem/18352)|339|[🚀](./특정거리의도시찾기.java)|✅|
|[연구소](https://www.acmicpc.net/problem/14502)|341|[🚀](./연구소.java)|✅|
|[경쟁적 전염](https://www.acmicpc.net/problem/18405)|344|[🚀](./경쟁적전염.java)|✅|
|[괄호 변환](https://programmers.co.kr/learn/courses/30/lessons/60058)|346|[🚀](./괄호변환.java)|✅|
|[연산자 끼워 넣기](https://www.acmicpc.net/problem/14888)|349|[🚀](./연산자끼워넣기.java)|✅|
|[감시 피하기](https://www.acmicpc.net/problem/18428)|351|[🚀](./감시피하기.java)|✅|
|[인구 이동](https://www.acmicpc.net/problem/16234)|353|[🚀](./인구이동.java)||
|[블록 이동하기](https://programmers.co.kr/learn/courses/30/lessons/60063)|355|[🚀](./블록이동하기.java)| |

