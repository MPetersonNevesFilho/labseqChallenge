
import axios from 'axios';


export const Labseq  = (nValue)  => {

    const url = 'http://localhost:8080/labseq/' + nValue;

    const getData = async () => {
        try {
            return await axios.get(url)
            .then(response => {
                return response
            })
            .catch(error => {
                console.log(error);
            });

        } catch (error) {
            console.log(error);
        }
    }

    return getData();
}

export const LabseqDelete = (nValue) => {

    const url = 'http://localhost:8080/labseq/' + nValue;

    const deleteData = async () => {
        try {
            return await axios.delete(url)
            .then(response => {
                console.log(response);
                return response;
            })
            .catch(error => {
                console.log(error);
            });

        } catch (error) {
            console.log(error);
        }
    }

    return deleteData();
}

export const RestartMemory = () => {

        const url = 'http://localhost:8080/labseq/restart';

        const deleteData = async () => {
            try {
                return await axios.delete(url)
                .then(response => {
                    console.log(response);
                    return response;
                })
                .catch(error => {
                    console.log(error);
                });

            } catch (error) {
                console.log(error);
            }
        }

        return deleteData();
}