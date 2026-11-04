# Procedimento de Versionamento Semântico e Rollback (A2)

## 1. Versionamento Semântico (SemVer)
Adotamos o padrão `MAJOR.MINOR.PATCH`:
- **MAJOR**: Mudanças incompatíveis na API.
- **MINOR**: Novas funcionalidades mantendo compatibilidade.
- **PATCH**: Correções de bugs.

## 2. Procedimento de Rollback

### Opção A: Rollback via Imagem Docker (Contêiner)
Se a versão mais recente apresentar erros em execução, reverta para a tag estável anterior no registro de contêineres:
1. `docker pull ghcr.io/mateusfogo2007/dev_OPS:v0.9.0`
2. `docker-compose down`
3. `docker-compose up -d`

### Opção B: Rollback via Git (Reversão de Commit)
Em caso de falha severa na branch `main`:
1. Identifique o commit defeituoso na aba "Commits" do GitHub.
2. Na página do commit, clique no botão "Revert" (canto superior direito).
3. Isso criará um novo Pull Request desfazendo aquelas alterações com segurança.
