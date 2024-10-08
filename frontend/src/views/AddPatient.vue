<template>
    <main>
        <Navbar/>

        <div class="my-5">
            <div class="mx-auto w-25" style="max-width: 100%;">
                <h2 class="text-center mb-3">Add Patient</h2>

                <form @submit.prevent="addPatient">
                    <!-- name -->
                    <div class="row">
                        <div class="col-md-12 form mb-3">
                            <label for="name" class="form-lable">Name</label>
                            <input type="text" name="name" id="name" class="form-control" placeholder="Name" required v-model="patient.name">
                        </div>
                    </div>

                    <!-- email -->
                    <div class="row">
                        <div class="col-md-12 form mb-3">
                            <label for="email" class="form-lable">Email</label>
                            <input type="text" name="email" id="email" class="form-control" placeholder="Email" required v-model="patient.email">
                        </div>
                    </div>

                    <!-- phone -->
                    <div class="row">
                        <div class="col-md-12 form mb-3">
                            <label for="pNo" class="form-lable">Phone Number</label>
                            <input type="text" name="pNo" id="pNo" class="form-control" placeholder="Phone number" required v-model="patient.pNo">
                        </div>
                    </div>

                    <!-- gender -->
                    <label for="gender" class="form-lable">Gender</label>
                    <div class="form-check">
                        <input type="radio" name="gender" id="male" value="male" v-model="patient.gender">
                        <label for="male" class="form-check-label">Male</label>
                    </div>
                    <div class="form-check">
                        <input type="radio" name="gender" id="female" value="female" v-model="patient.gender">
                        <label for="female" class="form-check-label">Female</label>
                    </div>
                    <div class="form-check">
                        <input type="radio" name="gender" id="others" value="others" v-model="patient.gender">
                        <label for="others" class="form-check-label">Male</label>
                    </div>

                    <div class="row">
                        <div class="col-md-12 form-group">
                             <input type="submit" value="Submit" class="btn btn-primary w-100">
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </main>
</template>

<script>
import Navbar from '../components/Navbar.vue'

export default {
    name: 'AddPatient',
    components: {
        Navbar
    },
    
    data() {
        return {
            patient:{
                name: '',
                email: '',
                pNo: '',
                gender: ''
            }
        }
    },

    methods:{
        addPatient(){
            fetch("http://localhost:8080/add", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.patient)
            })
            .then(data => {
                console.log('Success:', data)
                this.$router.push("/")
            })
        }
    }
 
}

</script>















