# SKILL: Issue-First Fix Flow

## Objective
Whenever a bug/adjustment is requested, execute a disciplined delivery flow:
1. Open or reference a GitHub Issue first.
2. Implement the fix.
3. Validate with tests locally.
4. Link the issue in commit message.
5. Push to feature branch.
6. Validate CI on feature branch.
7. Promote to `development` only after green validation.

## Mandatory checklist
- [ ] Create issue with clear title, root cause, acceptance criteria, and labels.
- [ ] Implement fix with minimal, reviewable diff.
- [ ] Run the relevant test scope locally (`mvn -B clean test` or targeted tests).
- [ ] Use commit message with closing keyword (example: `fix: ... (fixes #123)`).
- [ ] Push to working branch first.
- [ ] Confirm workflow status is successful on working branch.
- [ ] Merge/fast-forward to `development` and push.
- [ ] Update issue with resolution notes and commit hash.

## Commit conventions
- Bug fix: `fix: <short description> (fixes #<issue>)`
- Test/data fix: `test: <short description> (fixes #<issue>)`
- Workflow/CI fix: `ci: <short description> (fixes #<issue>)`

## Validation policy
- Never promote to `development` with failing local tests.
- If local tests fail, stop promotion, open/update issue, and continue fixing.

## Branch policy
- First push always to personal/feature branch (example: `RafaelBrum`).
- `development` receives only validated commits.
