class Reader:
    """defines class for Input View"""
    @staticmethod
    def register():
        """gets player's name and returns it (string)"""
        return input("Enter your name : ") 

    @staticmethod
    def ox(message):
        """returns True if player inputs 'o' or 'O', 
                   False if player inputs 'x' or 'X'"""
        response = input(message).lower()
        while not (response == 'o' or response == 'x'):
            response = input(message).lower()
        return response == 'o'

    # @staticmethod
    # def get_number(message,low,high):
    #     response = input(message)
    #     while not (response.isdigit() and low <= int(response) <= high):
    #         response = input(message)
    #     return int(response)


