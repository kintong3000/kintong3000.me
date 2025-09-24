import { ref } from 'vue'

// This composable manages the shared state for the documentation preview feature.
// It allows the sidebar (file browser) and the main content area (previewer)
// to communicate and stay in sync without direct prop drilling or complex event emitting.

export function useDocPreview() {
  // A static, shared state across all components that use this composable.
  // This is achieved by defining the state outside of the returned function scope.
  const selectedFile = ref(null)
  const previewType = ref('') // Can be 'md', 'pdf', or 'unsupported'
  const previewContent = ref('')
  const isLoading = ref(false)
  const error = ref<string | null>(null)

  return {
    selectedFile,
    previewType,
    previewContent,
    isLoading,
    error,
  }
}