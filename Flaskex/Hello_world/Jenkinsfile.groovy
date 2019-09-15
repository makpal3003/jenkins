node{
    stage("update Jenkins"){
        properties([parameters([string(defaultValue: '34.255.1.240', description: 'Please provide IP', name: 'ENVIR', trim: true)])])
        sh "echo Parameter added"
    }
    stage ("Install Git"){
        sh "ssh ec2-user@${ENVIR} sudo yum install git python-pip -y"
    }
    stage("Remove Repo"){
        sh "ssh ec2-user@${ENVIR} sudo rm -rf /home/ec2-user/flask-examples"
    }
    stage("Pull Repo"){
        sh "ssh ec2-user@${ENVIR} git clone https://github.com/leventelibal/flask-examples.git"
    }
    stage("Install Requirments"){
        //sh "virtualenv /tmp/venv"
        //sh ". venv/bin/activate"
        sh "echo Hello"
    }
    stage("Pip Install"){
        sh "ssh ec2-user@${ENVIR} sudo pip install -r /home/ec2-user/flask-examples/requirements.txt"
    }
    stage ("Run App"){
        sh "ssh ec2-user@${ENVIR} python  /home/ec2-user/flask-examples//01-hello-world/hello.py"
    }
}