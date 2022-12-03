#!/bin/bash
[ -f .project ] || {
	echo "Must be called from root of workspace!"
	exit 1
}
export AOSP_HOME="`grep -A 1 "<name>AOSP_HOME</name>" .project  | sed -ne 's#.*<value>file:\([^<]*\)</value>.*#\1#p'`"
export PROJECT_HOME=$PWD
(cd $AOSP_HOME
for f in `find . -type d -name .git` ; do
(cd $f/..
echo $f
git status 2>&1
)
done 2>&1 > /tmp/changelog.txt
)
for f in `grep -B 2 "Changes not staged for commit" /tmp/changelog.txt  | grep ".git"` ; do
echo $f
(cd $AOSP_HOME/$f/..
git status
) | sed -n -e "s/^\\t\(.*\)/\1/p"  | sed -e "/modified:   / s/modified:   \(.*\)/\1/" | sed -e "s#\(.*\)#mkdir -p \`realpath -m $PROJECT_HOME/src/$f/../\1/..\` ; cp $AOSP_HOME/$f/../\1 \`realpath -m $PROJECT_HOME/src/$f/../\1\`#"  | bash
done
