# OS Labs

Exercises for a Betriebssysteme (Operating Systems) course: Bash scripting, process/thread simulation in Java, and a small Kubernetes client in Rust.

## Contents

### Shell scripts (Bash)

| Script | Purpose |
|---|---|
| `calc.sh` | Command-line integer calculator. Usage: `calc.sh <int> <operator> <int>` where operator is one of `ADD`, `SUB`, `MULT`, `DIV`, `MOD`, `EXP`. |
| `nxls.sh` | Lists all **non-executable regular files** in a given directory. Usage: `nxls.sh <dir>`. |
| `premv.sh` | Renames every file starting with a given prefix to use a new prefix instead. Usage: `premv.sh <old-prefix> <new-prefix>`. |
| `backup.sh` | Interactively backs up files matching a suffix into a `backup/` folder, asking `j/n` (yes/no) for each file before copying. Usage: `backup.sh <suffix>`. |
| `quiz.sh` | Simple two-choice quiz loop: asks a question and repeats until one of two accepted answers is given. Usage: `quiz.sh "Frage" A1 A2`. Exit code 0 if `A1` was chosen, 1 if `A2` was chosen. |


### `processSimulator/` (Java)

A single-CPU process-scheduling simulator using `READY`, `RUNNING`, and `BLOCKED` states.

- **`Process.java`** — represents a process: id, accumulated runtime, and current state.
- **`ProsessState.java`** — enum of the three process states.
- **`Simulator.java`** — drives a 50-tick simulation with `ready`, `blocked`, and one `running` process, moving processes between the three states each tick (assign, resign, block, unblock) and printing the system state at every step.

### `ThreadSimulator/` (Java)

A two-thread traffic-light simulation demonstrating Java's `wait()`/`notifyAll()` coordination.

- **`Controller.java`** — shared, synchronized controller tracking which direction (`NORTH_SOUTH` / `EAST_WEST`) has the green light and the phase (`RED`/`YELLOW`/`GREEN`) of each direction.
- **`LightThread.java`** — a `Thread` per direction that waits for its turn to go green, switches phases, sleeps, then hands the green light to the other direction.
- **`TrafficLightSim.java`** — entry point; starts both direction threads.

### `kube-pod-list/` (Rust)

A minimal Kubernetes client that lists pods in the current namespace.

- Reads the local kubeconfig (`~/.kube/config`) or in-cluster config.
- Uses the `kube` and `k8s-openapi` crates (async, via `tokio`) to list pods and print each pod's name and status phase.
- Build/run with `cargo run` from inside `kube-pod-list/` (requires a reachable Kubernetes cluster/context).

## Requirements

- Bash (for the `.sh` scripts)
- JDK (for `processSimulator/` and `ThreadSimulator/`) — compile with `javac *.java` inside each folder, then run the file containing `main`.
- Rust/Cargo (for `kube-pod-list/`)