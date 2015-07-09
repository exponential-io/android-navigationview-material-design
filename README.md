# Android NavigationView via Material Design Support Library

Learn how to use the Material Design Support Library's NavigationView to create a drawer.

## Copy repo

Create new **empty** repo on GitHub

Run the following commands to base the new repo on the exising `android-actionbar-material-design` repo.

```bash
cd ~/repos/android

git clone git@github.com:exponential-io/android-actionbar-material-design.git android-navigationview-material-design

cd android-navigationview-material-design

git remote set-url origin git@github.com:exponential-io/android-navigationview-material-design.git

git push origin master

# View remote urls
git remote -v
```

## Rename project in Android Studio

- Open the new project in Android Studio.
- Right-click on **app** in the Project pane, click **Open Module Settings**.
- In the **Project Structure** dialog box, click the **Flavors** tab.
    - Change the **Application Id** to `io.exponential.mdnavigationview`.
    - Click **OK**.
- Open `build.gradle`:
    - Notice how `applicationId` has been changed to `io.exponential.mdnavigationview`.
- Open the `AndroidManifest.xml`:
    - Change the package to `io.exponential.mdnavigationview`.
- Refactor the `io.exponential.materialdesignactionbar` package to `io.exponential.mdnavigationview`.
- Open `MainActivity.java:
    - Change the package to `package io.exponential.mdnavigationview;`.
- Open `MainFragment.java:
    - Change the package to `package io.exponential.mdnavigationview;`.
- Open `strings.xml`:
    - Change `app_name` to `Material Design NavigationView`.
- Select **Build**, click **Clean**.
- Select **Build**, click **Rebuild Project**.
- Commit your changes to git.
- Select **File**, click **Invalidate Caches / Restart...**.

## Follow commit log

You can now start to follow the steps to implement the NavigationDrawer via the git commit log. Begin with the commits that are prefixed with `drawer:`.

