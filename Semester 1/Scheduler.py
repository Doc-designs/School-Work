

def basic_scheduler():
    activity = ""
    timeFrame = ""
    week = ["Monday", "Tuesday", "Wensday", "Thursday", "Friday", "Saturday", "Sunday"]
    for i in range(len(week)):
        while activity.lower() != "done":
            activity = input("Enter an Activity: ")
            timeFrame = input("Enter it's Starting and Ending Times: ")
