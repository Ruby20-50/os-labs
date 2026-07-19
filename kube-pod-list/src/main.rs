use kube::{Client, api::{Api, ListParams, ResourceExt}};
use k8s_openapi::api::core::v1::Pod; 

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    // Reads ~/.kube/config (or in-cluster config if running inside a pod)
    let client = Client::try_default().await?;

        // Api<Pod> scoped to the current namespace from your kubeconfig context
    let pods: Api<Pod> = Api::default_namespaced(client);

    for pod in pods.list(&ListParams::default()).await? {
        let status = pod
            .status
            .as_ref()
            .and_then(|s| s.phase.clone())
            .unwrap_or_else(|| "Unknown".into());

        println!("{:<40} {}", pod.name_any(), status);
    }

    Ok(())    
}
