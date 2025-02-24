# GIT ESSENTIALS 

#### 1. **Set Up Git (if you haven't done so yet)**

If you haven't already configured Git, open **Git Bash** (or Command Prompt) and set up your Git username and email:

```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

#### 2. **Create a GitHub Repository**

- Go to [GitHub](https://github.com/) and log in.
- Click the **+** icon in the top-right corner and select **New repository**.
- Name your repository (e.g., `my-project`), add a description, choose if it's public or private, and click **Create repository**.

#### 3. **Navigate to Your Local Project Folder**

Open **Git Bash** or Command Prompt and navigate to your project folder. For example:

```bash
cd /d/Path/To/Your/Project
```

#### 4. **Initialize a Git Repository in Your Local Project**

Run the following command to initialize your project folder as a Git repository:

```bash
git init
```

#### 5. **Rename `master` to `main` (if your default branch is `master`)**

Since your GitHub repository has a `main` branch and your local repository currently has `master`, rename your local `master` branch to `main`:

```bash
git branch -m master main
```

#### 6. **Add Project Files to Git**

Add all the files in your project to the staging area:

```bash
git add .
```

#### 7. **Commit Your Changes**

Commit the added files with a message:

```bash
git commit -m "Initial commit"
```

#### 8. **Link Your Local Repository to GitHub**

Copy the URL of your GitHub repository (e.g., `https://github.com/yourusername/my-project.git`) and link it to your local repository:

```bash
git remote add origin https://github.com/yourusername/my-project.git
```

#### 9. **Push Your Local Branch (`main`) to GitHub**

Push the local `main` branch to GitHub. This will upload your project to GitHub:

```bash
git push -u origin main
```

The `-u` flag will link your local `main` branch with the remote `main` branch, making future pushes simpler (just use `git push`).

#### 10. **Delete the `master` Branch from GitHub (Optional)**

If your GitHub repository previously had a `master` branch, you can delete it since you now have the `main` branch:

```bash
git push origin --delete master
```

#### 11. **Set the Default Branch to `main` (if needed)**

If the default branch on GitHub is still set to `master`, follow these steps:

- Go to your GitHub repository page.
- Click on **Settings** → **Branches**.
- In the **Default branch** section, change it to `main`.

8. Set the default branch on GitHub to `main` (if needed).

---

That's it! Your project should now be uploaded to GitHub and your local and remote branches should be in sync.

Let me know if you need help with any of the steps!
